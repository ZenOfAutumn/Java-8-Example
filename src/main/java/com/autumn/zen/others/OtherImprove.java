package com.autumn.zen.others;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class OtherImprove {

	// 1.String

	@Test
	public void testStringJoin() {
		Assert.assertEquals("1,2,3", String.join(",", "1", "2", "3"));
	}

	// 2.Number
	@Test
	public void testNumber() {
		Assert.assertEquals(Boolean.TRUE, Boolean.logicalAnd(true, true));
	}

	// 3.Math
	@Test
	public void testMath() {
		Assert.assertEquals(1, Math.floorMod(-1, 2));
	}

	// 4.Collection

	@Test
	public void testRemoveIf() {
		List<String> words = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			words.add(String.valueOf(i));
		}
		words.removeIf(x -> x.equals("2"));
		Assert.assertFalse(words.contains("2"));
	}

	
	static class Person{
		
		private String firstName;
		private String lastName;
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public Person(String firstName,String lastName) {
			this.firstName=firstName;
			this.lastName = lastName;
		}
		public Person(){
			
		}
		
	}
	
	@Test
	public void testComparator() {
		List<Person> workers = new ArrayList<Person>();
		workers.add(new Person("lebron", "james"));
		workers.add(new Person("chris","paul"));
		workers.add(new Person("chris","bosh"));
		Collections.sort(workers, Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
		Assert.assertEquals("bosh", workers.get(0).getLastName());
		
		Collections.sort(workers,Comparator.comparing(Person::getFirstName, (x,y)->Integer.compare(x.length(), y.length())).reversed());
		Assert.assertEquals("lebron", workers.get(0).getFirstName());

		workers.add(new Person());
		Collections.sort(workers,Comparator.comparing(Person::getFirstName, Comparator.nullsFirst((x,y)->Integer.compare(x.length(), y.length()))));
		Assert.assertEquals(null, workers.get(0).getFirstName());
	}
	
	// 5.File
	
	@Test
	public void testFileOp(){
		try(Stream<Path> entries = Files.list(Paths.get("."))){
			Assert.assertTrue(entries.anyMatch((s)->s.getFileName().toString().equals(".project")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Base64
	@Test
	public void testBase64(){
		Base64.Encoder encoder = Base64.getEncoder();
		String info = "autumn zen"+":"+"321456";
		String encoded = encoder.encodeToString(info.getBytes(StandardCharsets.UTF_8));
		Base64.Decoder decoder = Base64.getDecoder();
		String deInfo = new String(decoder.decode(encoded));
		Assert.assertEquals(info, deInfo);
	}
	
	// 6.Annotation
	// repeatable annotation
	@TestCase(params="4",expected="24")
	@TestCase(params="0",expected="1")
	public static long fatorial(int n){
		if(n==0 || n==1){
			return 1;
		}
		long factorial = 1;
		for(int i = 1;i<=n;i++){
			factorial*=i;
		}
		return factorial;
	}
	

	private @TestCase(expected = "1", params = "2") String value;
	
	
	// reflect get param name
	
	// javac -parameters SourceFile.java
	

	// 7.null check
	@Test
	public void testNullCheck(){
		Assert.assertTrue(Objects.isNull(null));
		Assert.assertTrue(Objects.nonNull(""));

	}
	
	// 8.pattern split
	
	@Test
	public void testPatternSplit(){
		String msg = "1a2b3c4";
		Stream<String> words = Pattern.compile("[a-c]").splitAsStream(msg);
		List<String>  expected =Stream.of("1","2","3","4").collect(Collectors.toList());
		Assert.assertTrue(expected.equals(words.collect(Collectors.toList())));
	}
		
	
	
	
	
	
	
	
	
	
	

}
