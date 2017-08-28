package com.autumn.zen.lambda.program;

import java.util.function.UnaryOperator;

public class SelectFunctionalInterface {

	// 1.String process
	public static String transform(String in, UnaryOperator<String> f) {
		return f.apply(in);
	}

	// 2.self define functional interface

	@FunctionalInterface
	interface ColorTransformer {
		// change the color at (x,y)
		int apply(int x, int y, int origin);
	}

}
