package com.autumn.zen.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import org.junit.Assert;
import org.junit.Test;

public class TemporalAdjusterCase {

	public static LocalDate nextTuesday(int year, int month, int dayOfMonth) {
		return LocalDate.of(year, month, dayOfMonth).with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
	}

	@Test
	public void testNextTuesday() {
		LocalDate expect = LocalDate.of(2017, 8, 29);
		Assert.assertEquals(expect, nextTuesday(2017, 8, 28));
	}

	@Test
	public void testLastInMonth() {
		LocalDate actual = LocalDate.of(2017, 8, 28).with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
		LocalDate expect = LocalDate.of(2017, 8, 25);
		Assert.assertEquals(expect, actual);

	}

	public static TemporalAdjuster nextWorkday() {
		return w -> {
			LocalDate nextWorkday = (LocalDate) w;
			do {
				nextWorkday = nextWorkday.plusDays(1);
			} while (nextWorkday.getDayOfWeek().getValue() >= 6);
			return nextWorkday;
		};
	}

	@Test
	public void testNextWorkday() {
		LocalDate expect = LocalDate.of(2017, 9, 4);
		Assert.assertEquals(expect, LocalDate.of(2017, 9, 1).with(nextWorkday()));
	}

}
