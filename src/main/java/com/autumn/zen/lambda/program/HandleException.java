package com.autumn.zen.lambda.program;

import java.util.function.Consumer;

import org.junit.Test;

public class HandleException {

	// 1.async process

	public static void doInOrderAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					first.run();
					second.run();
				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		t.start();
	}
	
	
	@Test
	public void testDoInOrderAsync(){
		doInOrderAsync(()->{throw new NullPointerException("null pointer");}, ()->{}, t->System.out.println(t.getMessage()));
	}
	
	
}
