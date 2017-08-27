package com.autumn.zen.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class Aggregation {

	// 1.count
	private static long count = Stream.of(1, 2, 3, 4, 5).count();

	// 2.max
	private static Optional<String> largest = Stream.of("a", "ab", "abc").max(String::compareToIgnoreCase);

	// 3.min
	private static Optional<String> smallest = Stream.of("a", "ab", "abc").min(String::compareToIgnoreCase);

	// 4.find first
	private static Optional<String> firstWithB = Stream.of("a", "ab", "bc").filter(w -> w.startsWith("b")).findFirst();

	// 5.find any
	private static Optional<String> anyWithA = Stream.of("a", "ab", "bc").filter(w -> w.startsWith("a")).findAny();

	// 6.any match
	private static boolean anyMatch = Stream.of("a", "ab", "bc").parallel().anyMatch(s -> s.startsWith("b"));

	// 7.all match
	private static boolean allMatch = Stream.of("a", "ab", "bc").parallel().allMatch(s -> s.startsWith("b"));

	// 8.none match
	private static boolean noneMatch = Stream.of("a", "ab", "bc").parallel().noneMatch(s -> s.startsWith("c"));

	// 2.reduce
	private static Optional<Integer> sum = Stream.of(1, 2, 3, 4, 5).reduce((x, y) -> x + y);

	private static Integer sumWithInit = Stream.of(1, 2, 3, 4, 5).reduce(1, (x, y) -> x + y);

	private static int wordLength = Stream.of("a", "ab", "abc").reduce(0, (total, word) -> total + word.length(),
			(totalLeft, totalRight) -> totalLeft + totalRight);

	// 3.sum
	private static int wordsLength = Stream.of("a", "ab", "abc").mapToInt(String::length).sum();

	public static void main(String[] args) {
		if (largest.isPresent()) {
			System.out.println(largest);
		}
		if (smallest.isPresent()) {
			System.out.println(smallest);
		}

		if (anyWithA.isPresent()) {
			System.out.println(anyWithA.toString());
		}

		System.out.println(allMatch);
		System.out.println(anyMatch);
		System.out.println(noneMatch);
	}

}
