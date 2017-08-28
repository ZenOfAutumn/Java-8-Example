package com.autumn.zen.lambda.expression;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.autumn.zen.annotation.NotThreadSafe;

public class VariableScopes {

	// lambda表达式可以捕获闭合作用域中的变量值，但变量值必须为不可变的

	static void repeatMessage(String msg, int repeatTimes) {
		Runnable r = () -> {
			for (int i = 0; i < repeatTimes; i++) {
				System.out.println(msg);
			}
		};
		Thread t = new Thread(r);
		t.start();
	}

	@NotThreadSafe
	static List<Path> filterMatchPath(List<Path> paths) {
		List<Path> matches = new ArrayList<Path>();
		for (Path path : paths) {
			new Thread(() -> {
				if (path.startsWith("/home")) {
					matches.add(path);
				}
			}).start();
		}
		return matches;
	}

	// lambda表达式的方法体与嵌套代码块有着相同的作用域

	static class FinalToString {

		public void doWork() {
			new Thread(() -> {
				System.out.println(this.toString());
			}).start();
		}

		@Override
		public String toString() {
			return "final to string";
		}
	}

	public static void main(String[] args) {
		FinalToString fts = new FinalToString();
		fts.doWork();
	}

}
