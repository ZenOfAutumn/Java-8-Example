package com.autumn.zen.lambda.program;

import java.util.function.UnaryOperator;

public class Compose {

	// 1.composen
	public static <T> UnaryOperator<T> compose(UnaryOperator<T> leftOp, UnaryOperator<T> rihtOp) {
		return t -> rihtOp.apply(leftOp.apply(t));
	}

}
