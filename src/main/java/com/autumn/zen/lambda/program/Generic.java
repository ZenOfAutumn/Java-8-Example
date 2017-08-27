package com.autumn.zen.lambda.program;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Generic {

	// generic lambda
	public static <T> void doInOrderAsync(Supplier<? extends T> first, Consumer<? super T> second,
			Consumer<? super Throwable> handler) {

	}

}
