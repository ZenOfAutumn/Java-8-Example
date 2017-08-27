package com.autumn.zen.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class FilterAndMap {

	// 1.filter
	public List<String> filterShort(List<String> words, int max) {
		return words.stream().filter(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				if (t.length() <= max) {
					return true;
				}
				return false;
			}
		}).collect(Collectors.toList());
	}
	
	public List<String> filterShortWithImpl(List<String> words,int max){
		return words.stream().filter(w->w.length()<=max).collect(Collectors.toList());
	}
	
	
	public static List<String> createTestData(){
		List<String> test = new ArrayList<String>();
		test.add("a");
		test.add("ab");
		test.add("abc");
		test.add("abcd");
		test.add("abcde");
		return test;
	}
	
	@Test
	public void testFilterShort(){
		Assert.assertTrue(filterShort(createTestData(), 3).size() == 3);
		Assert.assertTrue(filterShortWithImpl(createTestData(), 3).size() == 3);
	}
	
	// 2.map
	
	public List<String> toLowerCase(List<String> words){
		return words.stream().map(String::toLowerCase).collect(Collectors.toList());
	}
	
	
	@Test
	public void testToLowerCase(){
		List<String> test = new ArrayList<String>();
		test.add("ABCD");
		Assert.assertEquals("abcd", toLowerCase(test).get(0));
	}
	
	// 3.flatMap
	
	public static Stream<Character> characterStream(String word){
		List<Character> chars = new ArrayList<Character>();
		for(Character c:word.toCharArray()){
			chars.add(c);
		}
		return chars.stream();
	}
	
	
	public List<Character> combineCharacters(List<String> words){
		return words.stream().flatMap(w->characterStream(w)).collect(Collectors.toList());
	}

	
	@Test
	public void  testCombineCharacters(){
			Assert.assertEquals(15,combineCharacters(createTestData()).size());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
