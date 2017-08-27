package com.autumn.zen.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class StatusTransfer {

	// 1.distinct
	private static Stream<String> uniqueWords = Stream.of("a", "a", "b", "b").distinct();

	// 2.sorted
	private static Stream<String> longestFirst = Stream.of("a", "ab", "abc")
			.sorted(Comparator.comparing(String::length).reversed());

	

}
