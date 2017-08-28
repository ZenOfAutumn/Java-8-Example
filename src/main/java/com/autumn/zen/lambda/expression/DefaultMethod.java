package com.autumn.zen.lambda.expression;

import org.junit.Assert;
import org.junit.Test;

public class DefaultMethod {

	static interface Person {

		int getId();

		default String getName() {
			return "default name";
		}

	}

	static class Man {

		public String getName() {
			return "man";
		}
	}

	static interface Worker {
		default String getName() {
			return "worker";
		};
	}

	// 1.如果一个父类提供了具体的实现方法，那么接口中具有同名称和参数的默认方法会被忽略。

	static class Father extends Man implements Person {

		@Override
		public int getId() {
			return 0;
		}

	}

	@Test
	public void testGetName() {
		Father father = new Father();
		Assert.assertEquals("man", father.getName());
	}

	// 2.如果两个父接口提供了相同名称和参数类型的方法,其中有一个提供了默认方法，实现类必须覆盖方法解决冲突。

	static class Mother implements Person, Worker {

		@Override
		public String getName() {
			return Worker.super.getName();
		}

		@Override
		public int getId() {
			return 1;
		}

	}

}
