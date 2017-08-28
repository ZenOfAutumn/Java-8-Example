package com.autumn.zen.lambda.program;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import org.junit.Assert;
import org.junit.Test;

public class LaztOperation {

	static class StringHolder {
		private String str;
		private List<UnaryOperator<String>> ops = new ArrayList<UnaryOperator<String>>();

		public StringHolder(String str) {
			this.str = str;
		}

		StringHolder apply(UnaryOperator<String> op) {
			ops.add(op);
			return this;
		}

		String process() {
			for (UnaryOperator<String> op : ops) {
				str = op.apply(str);
			}
			return str;

		}
	}

	@Test
	public void testDelayPro() {
		StringHolder ori = new StringHolder("");
		for (int i = 0; i < 3; i++) {
			final int j = i;
			ori.apply((s) -> s + j);
		}
		Assert.assertEquals("012", ori.process());
	}

}
