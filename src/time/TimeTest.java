package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * ICE 3: JUnit tests for Time.java, Added tests for getMilliseconds
 * @author Jatinder Bhachu
 * @date January 24, 2022
 */
class TimeTest {

	@Test
	void testGetTotalSecondsGood() {
		assertTrue("Total seconds were not calculated properly", Time.getTotalSeconds("00:00:10") == 10);
		assertTrue("Total seconds were not calculated properly", Time.getTotalSeconds("01:01:05") == 3665);
		assertTrue("Total seconds were not calculated properly", Time.getTotalSeconds("01:00:05") == 3605);
	}
	
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class, () -> { Time.getTotalSeconds("00"); });
		assertThrows(
				NumberFormatException.class, () -> { Time.getTotalSeconds("xyz"); });
	}

	@Test
	void testGetTotalSecondsBoundary() {
		assertTrue("Total seconds were not calculated properly", Time.getTotalSeconds("00:00:00") == 0);
		assertTrue("Total seconds were not calculated properly", Time.getTotalSeconds("11:59:59") == 43199);
	}
	
	
	@Test
	void testGetSecondsGood() {
		assertTrue("Seconds were not calculated properly", Time.getSeconds("00:00:05") == 5);
		assertTrue("Seconds were not calculated properly", Time.getSeconds("00:00:30") == 30);
	}

	@Test
	void testGetSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class, () -> { Time.getSeconds("0"); });
		assertThrows(
				NumberFormatException.class, () -> { Time.getSeconds("00:00:xx"); });
	}
	
	@Test
	void testGetSecondsBoundary() {
		assertTrue("Seconds were not calculated properly", Time.getSeconds("00:00:00") == 0);
		assertTrue("Seconds were not calculated properly", Time.getSeconds("00:00:59") == 59);
		assertTrue("Seconds were not calculated properly", Time.getSeconds("11:59:59") == 59);
	}
	
	@Test
	void testGetTotalMinutesGood() {
		assertTrue("Minutes were not calculated properly", Time.getTotalMinutes("01:10:00") == 10);
		assertTrue("Minutes were not calculated properly", Time.getTotalMinutes("02:36:00") == 36);
	}

	@Test
	void testGetTotalMinutesBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class, () -> { Time.getTotalMinutes("0"); });
		assertThrows(
				NumberFormatException.class, () -> { Time.getTotalMinutes("00:xx:00"); });	
	}
	
	@Test
	void testGetTotalMinutesBoundary() {
		assertTrue("Minutes were not calculated properly", Time.getTotalMinutes("00:00:00") == 0);
		assertTrue("Minutes were not calculated properly", Time.getTotalMinutes("00:59:00") == 59);

	}
	
	@Test
	void testGetTotalHoursGood() {
		assertTrue("Hours were not calculated properly", Time.getTotalHours("05:00:00") == 5);
		assertTrue("Hours were not calculated properly", Time.getTotalHours("11:00:00") == 11);
	}

	@Test
	void testGetTotalHoursBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class, () -> { Time.getTotalHours("0"); });
		assertThrows(
				NumberFormatException.class, () -> { Time.getTotalHours("xx:00:00"); });
	}

	@Test
	void testGetTotalHoursBoundary() {
		assertTrue("Hours were not calculated properly", Time.getTotalHours("11:59:59") == 11);
		assertTrue("Hours were not calculated properly", Time.getTotalHours("00:00:00") == 0);
	}
	
	@Test
	void testGetMillisecondsGood() {
		assertTrue("Milliseconds were not calculated properly", Time.getMilliseconds("12:05:05:005") == 5);
		assertTrue("Milliseconds were not calculated properly", Time.getMilliseconds("12:05:05:015") == 15);
	}

	@Test
	void testGetMillisecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class, () -> { Time.getMilliseconds("12:015"); });
		assertThrows(
				NumberFormatException.class, () -> { Time.getMilliseconds("12:05:05:FFF"); });
	}

	@Test
	void testGetMillisecondsBoundary() {
		assertTrue("Milliseconds were not calculated properly", Time.getMilliseconds("12:05:05:000") == 0);
		assertTrue("Milliseconds were not calculated properly", Time.getMilliseconds("12:05:05:999") == 999);
	}
}
