package com.autumn.zen.datetime;

import java.time.Instant;
import java.util.Date;

public class RemainCode {

	// 1.to

	static final Instant INS = new Date().toInstant();

	// 2.from

	static final Date DATE = Date.from(Instant.now());

}
