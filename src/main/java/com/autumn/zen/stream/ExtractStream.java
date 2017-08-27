package com.autumn.zen.stream;

import java.util.stream.Stream;

public class ExtractStream {

	// 1.limit
	private static Stream<Double> randoms = Stream.generate(Math::random).limit(100);

	// 2.skip
	private static Stream<String> chars = Stream.of(new String[] { "1", "2", "3" }).skip(1);

	// 3.concat
	private static Stream<String> concats = Stream.concat(Stream.of(new String[] { "1", "2", "3" }),
			Stream.of(new String[] { "4", "5", "6" }));

	// 4.peek
	private static Stream<Double> doubles = Stream.iterate(1.0, p -> p * 2)
			.peek(e -> System.out.println("fetching: " + e)).limit(20);

	

	
}
