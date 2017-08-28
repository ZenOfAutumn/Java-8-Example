package com.autumn.zen.datetime;

import java.time.Duration;
import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;

public class TimeLine {

	// Instant
	@Test
	public void testInstant() {
		Instant start = Instant.now();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant end = Instant.now();
		Duration timeElasped = Duration.between(start, end);
		long millis = timeElasped.toMillis();
		Assert.assertEquals(500, millis);

		// plus
		Duration duration = Duration.ofMillis(500);
		Assert.assertEquals(501, duration.plusMillis(1).toMillis());

		// minus
		timeElasped.minusMillis(1);
		Assert.assertEquals(499, duration.minusMillis(1).toMillis());

	}

}
