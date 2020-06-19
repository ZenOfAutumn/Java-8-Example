package com.autumn.zen.concurrency;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;

public class CompletableFutureCase {
	
	// 1.then apply
	@Test
	public void thenApply(){
		
		CompletableFuture<String> contents = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Thread.currentThread().getName();
		});
			
		
		CompletableFuture<Boolean> isSameThread = contents.thenApply(x->{
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(x.equals(Thread.currentThread().getName())){
				return true;
			}else{
				return false;
			}
		});
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isSameThread.thenAccept(s->System.out.println(s));
	}	
	
	// 2.then after both
	@Test
	public void thenAfterBoth(){
		
		CompletableFuture<String> threadLeft = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Thread.currentThread().getName();
		});
		
		CompletableFuture<String> threadRight = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Thread.currentThread().getName();
		});
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(threadLeft.get());
			System.out.println(threadRight.get());
		}catch (Exception e){

		}

		threadRight.thenAcceptBoth(threadLeft, (t,u)->System.out.println(t+"|"+u));
	}	
	
	
	
	
	
	
	
	
	
	

}
