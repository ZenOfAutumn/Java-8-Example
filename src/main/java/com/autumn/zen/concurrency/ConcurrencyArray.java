package com.autumn.zen.concurrency;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ConcurrencyArray {
	
	// 1.parallel sort
	
	public static void sort(String[] words){
		 Arrays.parallelSort(words);
	}
	
	// 2.parallel set all
	public static void parallelSetAll(String[] words){
		Arrays.parallelSetAll(words, (i)->String.valueOf(i));
	}
	
	@Test
	public void testParallelSetAll(){
		String[] words = new String[3];
		parallelSetAll(words);
		Assert.assertArrayEquals(new String[]{"0","1","2"},words);
	}
	
	// 3.parallel prefix
	
	public static void parrallelPrefix(String[] words){
		Arrays.parallelPrefix(words, (x,y)->String.valueOf(x)+String.valueOf(y));
	}

	@Test
	public void testParrallelPrefix(){
		String[] words = new String[]{"0","1","2"};
		parrallelPrefix(words);
		Assert.assertArrayEquals(new String[]{"0","01","012"},words);

	}
	
	
	

}
