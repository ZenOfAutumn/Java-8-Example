package com.autumn.zen.lambda.program;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ConcurrentOperation {

	public static void concurrentOps(List<String> words) {
		int n = Runtime.getRuntime().availableProcessors();
		try {
			ExecutorService pool = Executors.newFixedThreadPool(n);
			for (String word : words) {
				pool.submit(() -> {
					System.out.println(Thread.currentThread().getName() + ":" + word);
				});
			}
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void display() {
		List<String> array = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			array.add(String.valueOf(i));
		}
		concurrentOps(array);
	}

}
