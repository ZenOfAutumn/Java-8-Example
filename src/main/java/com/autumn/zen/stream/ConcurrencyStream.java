package com.autumn.zen.stream;

import java.util.stream.Stream;

import org.junit.Test;

public class ConcurrencyStream {

	// 1.parallel
	static Stream<String> words = Stream.of("hello","world","china","beijing").parallel();
	
	@Test
	public void forEach(){	
		words.forEach(s->System.out.println(Thread.currentThread().getName()+":"+s));
	}
	
	
}
