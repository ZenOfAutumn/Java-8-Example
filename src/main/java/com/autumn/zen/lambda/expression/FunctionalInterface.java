package com.autumn.zen.lambda.expression;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class FunctionalInterface {

	static void sortWords(String[] words) {
		Arrays.sort(words, (left, right) -> Integer.compare(left.length(), right.length()));
	}

	static Runnable exceptionCatchLambda() {
		Runnable sleeper = () -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		return sleeper;
	}

	static Callable<Void> exceptionThrowLambda() {

		Callable<Void> sleeper = () -> {
			Thread.sleep(1000);
			return null;
		};
		return sleeper;
	}

}
