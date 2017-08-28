package com.autumn.zen.lambda.expression;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class InterfaceStaticMethod {

	// 接口静态方法
	static interface Collections {

		public static <T> List<T> nCopies(int n, T o) {
			if (n < 0) {
				throw new IllegalArgumentException("List length = " + n);
			}
			List<T> copies = new ArrayList<T>(n);
			for (int i = 0; i < n; i++) {
				copies.add(o);
			}
			return copies;
		}
	}

	@Test
	public void testCopy() {
		String copy = "copy";
		List<String> nCopies = Collections.nCopies(10, copy);
		for (String nCopy : nCopies) {
			Assert.assertTrue(nCopy == copy);
		}
	}

}
