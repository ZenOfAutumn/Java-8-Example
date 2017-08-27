package com.autumn.zen.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OriginStream {
	
	// 1.of
	static IntStream istream = IntStream.of(1,1,2,3,5);
	static int[] values = new int[]{1,1,2,3,5};
	static IntStream intStream = Arrays.stream(values,0,values.length);
	
	// 2.range 
	static IntStream rangeStream = IntStream.range(0,100);
	static IntStream rangeClosedStream = IntStream.rangeClosed(0,100);
	
	// 3.map to int
	static IntStream str2IntStream = Stream.of("1","12","123").mapToInt(String::length);
	
	
	

}
