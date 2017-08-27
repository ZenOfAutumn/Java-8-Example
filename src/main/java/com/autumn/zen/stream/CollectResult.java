package com.autumn.zen.stream;

import java.util.Collections;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectResult {

	Stream stream = Stream.of("a", "ab", "abc");

	// 1.toArray

	private static String[] words = Stream.of("a", "ab", "abc").toArray(String[]::new);

	// 2.collect
	private static List<String> wordList = Stream.of("a", "ab", "abc").collect(Collectors.toList());
	private static Set<String> wordSet = Stream.of("a", "ab", "abc").collect(Collectors.toSet());
	private static Set<String> wordTreeSet = Stream.of("a", "ab", "abc").collect(Collectors.toCollection(TreeSet::new));
	private static String stringJoin = Stream.of("a", "ab", "abc").collect(Collectors.joining(","));

	// 3.summarize

	private static IntSummaryStatistics summary = Stream.of("a", "ab", "abc")
			.collect(Collectors.summarizingInt(String::length));
	private static double average = summary.getAverage();
	private static double max = summary.getMax();

	// 4.for each
	public static void forEach() {
		Stream.of("a", "ab", "abc").forEach(System.out::println);
	}

	public static void forEachOrdered() {
		Stream.of("a", "ab", "abc").forEachOrdered(System.out::println);
	}

	// 5.collect to map

	public static Map<String, String> languageNames = Stream.of(Locale.getAvailableLocales()).collect(Collectors.toMap(
			Locale::getDisplayLanguage, l -> l.getDisplayLanguage(), (existingValue, newValue) -> existingValue));

	public static Map<String, Set<String>> countryLanguageSets = Stream.of(Locale.getAvailableLocales()).collect(
			Collectors.toMap(l -> l.getDisplayCountry(), l -> Collections.singleton(l.getDisplayLanguage()), (a, b) -> {
				Set<String> r = new HashSet<String>(a);
				r.addAll(b);
				return r;
			}));

	static class Person {
		private int id;
		private String name;

		public Person(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}
	}

	public static Map<Integer, Person> id2Person = Stream
			.of(new Person(0, "mike"), new Person(1, "gates"), new Person(2, "zuck"))
			.collect(Collectors.toMap(Person::getId, Function.identity(), (existingValue, newValue) -> {
				throw new IllegalStateException();
			}, TreeMap::new));

	public static Map<String, String> languageNamesConcurrentMap = Stream.of(Locale.getAvailableLocales())
			.collect(Collectors.toConcurrentMap(Locale::getDisplayLanguage, l -> l.getDisplayLanguage(),
					(existingValue, newValue) -> existingValue));

}
