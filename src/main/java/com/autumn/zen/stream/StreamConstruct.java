package com.autumn.zen.stream;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamConstruct {

	// 1.集合转化Stream

	private Stream<String> collectionStream = new ArrayList<String>().stream();

	// 2.数组转化Stream

	private Stream<String> arrayStream = Stream.of(new String[] {});

	private Stream<String> arrays = Arrays.stream(new String[] {}, 0, 0);

	// 3.可变参数Stream
	private Stream<String> song = Stream.of("gently", "down", "the", "stream");

	// 4.空Stream
	private Stream<String> silence = Stream.empty();

	// 5.创建Stream的静态方法
	private Stream<String> echos = Stream.generate(() -> "Echo");
	private Stream<Double> randoms = Stream.generate(Math::random);

	private Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));

}
