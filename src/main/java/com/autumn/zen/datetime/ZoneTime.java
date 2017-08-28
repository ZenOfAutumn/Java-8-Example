package com.autumn.zen.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

public class ZoneTime {

	@Test
	public void allZoneTime() {
		LocalDateTime ldt = LocalDateTime.now();
		for (String zoneId : ZoneId.getAvailableZoneIds()) {
			ZoneId zid = ZoneId.of(zoneId);
			ZonedDateTime zdt = ldt.atZone(zid);
			System.out.println(zdt);
		}
	}
}
