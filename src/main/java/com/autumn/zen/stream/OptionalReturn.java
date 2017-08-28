package com.autumn.zen.stream;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalReturn {

	// 1.is present
	public static Optional<String> optional = Stream.of("a", "ba", "cab").max(String::compareToIgnoreCase);

	static void present() {
		optional.ifPresent(s -> System.out.println(s));
	}

	static void map() {
		optional.map(s -> s + "d");
	}

	// 2.or else
	public static Optional<String> empty = Stream.of("a", "ba", "cab").filter(s -> s.startsWith("d")).findFirst();

	static String orElse() {
		return empty.orElse("default");
	}

	static String orElseGet() {
		return empty.orElseGet(() -> System.getProperty("user.dir"));
	}

	static void orElseThrow() throws NoSuchElementException {
		empty.orElseThrow(NoSuchElementException::new);
	}

	// 3.of/empty

	public static Optional<Double> inverse(Double x) {
		return x == 0 ? Optional.empty() : Optional.of(1 / x);
	}

	public static Optional<String> option(String s) {
		return Optional.ofNullable(s);
	}

	public static Optional<Double> squareRoot(Double x) {
		return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
	}

	// 4.flatMap
	public static Optional<Double> zx = Optional.of(4.0).flatMap(OptionalReturn::inverse)
			.flatMap(OptionalReturn::squareRoot);

}
