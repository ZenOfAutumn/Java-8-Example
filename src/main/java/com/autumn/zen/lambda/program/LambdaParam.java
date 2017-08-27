package com.autumn.zen.lambda.program;

import java.util.function.IntConsumer;

import org.junit.Test;

public class LambdaParam {

	// action
	public static void repeat(int x, IntConsumer action) {
		for (int i = 0; i < x; i++) {
			action.accept(i);
		}
	}

	@Test
	public void testRepeatConsumer() {
		repeat(4, (x) -> System.out.println(x));
	}

	// runnable
	public static void repeat(int x, Runnable action) {
		for (int i = 0; i < x; i++) {
			action.run();
		}
	}

	@Test
	public void testRepeatRunnable() {
		repeat(10, () -> System.out.println("hello word"));
	}

}
