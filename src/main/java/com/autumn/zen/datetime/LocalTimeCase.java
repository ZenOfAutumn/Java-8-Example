package com.autumn.zen.datetime;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

public class LocalTimeCase {

	public static LocalTime nextHour(int hour, int minute, int second) {
		return LocalTime.of(hour, minute, second).plusHours(1);
	}

	@Test
	public void testNextHour() {
		LocalTime actual = nextHour(20, 59, 59);
		Assert.assertEquals(LocalTime.of(21, 59, 59), actual);
	}

}
