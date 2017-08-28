package com.autumn.zen.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormatAndParse {

	static final String ISO = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());

	static final String LOCAL_DATE = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)
			.format(LocalDateTime.now());

	static final String LOCAL_DATE_SHORT = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
			.format(LocalDateTime.now());

	static final String LOCAL_DATE_SELF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
			.format(LocalDateTime.now());

	static final LocalDate LOCAL_DATE_PARSE = LocalDate.parse("1990-11-12");

}
