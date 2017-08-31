package com.autumn.zen.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

import org.junit.Assert;
import org.junit.Test;

public class AtomicValue {

	private static final AtomicLong LARGEST = new AtomicLong(0);

	// 1.update and get

	long updateAndGet(long compare) {
		return LARGEST.updateAndGet(x -> Math.max(x, compare));
	}

	@Test
	public void testUpdateAndGet() {
		LARGEST.set(0);
		Assert.assertEquals(0, updateAndGet(-1));
	}

	// 2.accumulate and get
	long accumulateAndGet(int add) {
		return LARGEST.accumulateAndGet(add, (x, y) -> x + y);
	}

	@Test
	public void testAccumulateAndGet() {
		LARGEST.set(0);
		Assert.assertEquals(1, accumulateAndGet(1));
	}

	// 3.get and update

	long getAndUpdate(int update) {
		return LARGEST.getAndUpdate(x -> x = update);
	}

	@Test
	public void testGetAndUpdate() {
		LARGEST.set(0);
		Assert.assertEquals(0, getAndUpdate(2));
	}

	// 4.get and accumulate

	long getAndAccumulate(int add) {
		return LARGEST.getAndAccumulate(add, (x, y) -> x + y);
	}

	@Test
	public void testgetAndAccumulate() {
		LARGEST.set(0);
		Assert.assertEquals(0, getAndUpdate(2));
	}

	// 5.LongAdder

	final LongAdder adder = new LongAdder();

	long concurrentAdd(int threadNum, int max) {

		final LongAdder adder = new LongAdder();
		ExecutorService pool = Executors.newFixedThreadPool(4);
		for (int i = 0; i < threadNum; i++) {
			pool.submit(() -> {
				int j = 0;
				while (j < max) {
					adder.increment();
					j++;
				}
			});
		}

		pool.shutdown();
		while (!pool.isTerminated()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return adder.sum();
	}

	@Test
	public void testConcurrentAdd() {
		Assert.assertEquals(100, concurrentAdd(10, 10));
	}

	// 6.LongAccumulator

	long concurrentAccumulate(int threadNum) {

		final LongAccumulator maxer = new LongAccumulator(Math::max, 0);
		ExecutorService pool = Executors.newFixedThreadPool(4);
		for (int i = 0; i < threadNum; i++) {
			final int j = i;
			pool.submit(() -> {
				int l = j;
				for (int k = 0; k < 10; k++) {
					maxer.accumulate(l);
					l++;
				}
			});
		}

		pool.shutdown();
		while (!pool.isTerminated()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return maxer.get();
	}
	
	@Test
	public void testConcurrentAccumulate() {
         Assert.assertEquals(12, concurrentAccumulate(4));
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
