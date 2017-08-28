package com.autumn.zen.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import org.junit.Assert;
import org.junit.Test;

public class LocalDateCase {

	// local date
	@Test
	public void testLocalDate() {
		LocalDate ldf = LocalDate.now();
		LocalDate lambdaAuthorBirth = LocalDate.of(1903, 6, 14);
		LocalDate prophetBirth = LocalDate.of(1990, Month.DECEMBER, 31);

		// plus days
		Assert.assertEquals(LocalDate.of(1991, 1, 1), prophetBirth.plusDays(1));

		// period
		Period period = lambdaAuthorBirth.until(LocalDate.of(2017, 8, 28));
		Assert.assertEquals(114, period.getYears());
		Assert.assertEquals(2, period.getMonths());
		Assert.assertEquals(14, period.getDays());

	}

}
