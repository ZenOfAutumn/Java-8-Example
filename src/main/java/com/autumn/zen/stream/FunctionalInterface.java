package com.autumn.zen.stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class FunctionalInterface {

	// 1.Supplier
	static class Supply implements Supplier<String> {
		@Override
		public String get() {
			return "hello world";
		}
	}

	// 2.Consumer
	static class ConsumerImpl implements Consumer<String> {
		@Override
		public void accept(String t) {
			System.out.println(t);
		}
	}

	// 3.BiConsumer
	static class BiConsumerImpl implements BiConsumer<String, Integer> {

		@Override
		public void accept(String t, Integer u) {
			System.out.println(t + u);
		}

	}

	// 4.Predicate
	static class PredicateImpl implements Predicate<String> {
		@Override
		public boolean test(String t) {
			if (t.contains("a")) {
				return true;
			}
			return false;
		}
	}

	// 5.ToIntFunction
	static class ToIntFunctionImpl implements ToIntFunction<String> {
		@Override
		public int applyAsInt(String value) {
			return value.length();
		}
	}

	// 6.IntFunction
	static class IntFunctionImpl implements IntFunction<String> {
		@Override
		public String apply(int value) {
			return String.valueOf(value);
		}
	}

	// 7.Function
	static class FunctionImpl implements Function<String, Integer> {
		@Override
		public Integer apply(String t) {
			return t.length();
		}
	}

	// 8.BiFunction
	static class BiFunctionImpl implements BiFunction<String, String, Integer> {
		@Override
		public Integer apply(String t, String u) {
			return t.length() + u.length();
		}
	}
	
	
	// 9.UnaryOperator
	static class UnaryOperatorImpl implements UnaryOperator<String>{
		@Override
		public String apply(String t) {
			return t+":"+t.length();
		}
	}
	
    // 10.BinaryOperator
	
	static class BinaryOperatorImpl implements BinaryOperator<String>{
		@Override
		public String apply(String t, String u) {
			return t+u;
		}
	}

	
}
