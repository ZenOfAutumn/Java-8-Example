package com.autumn.zen.stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAndPartition {

	// 1.group by
	static Map<String, List<Locale>> country2Locales = Stream.of(Locale.getAvailableLocales())
			.collect(Collectors.groupingBy(Locale::getCountry));

	// 2.partition
	static Map<Boolean, List<Locale>> englishAndOtherLocales = Stream.of(Locale.getAvailableLocales())
			.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
	static List<Locale> enLocales = englishAndOtherLocales.get(true);

	// 3.downstream collector

	// similar to: select country, distinct * from locale group by country;
	static Map<String, Set<Locale>> country2LocaleSet = Stream.of(Locale.getAvailableLocales())
			.collect(Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));

	// similar to: select country, count(*) from locale group by country;
	static Map<String, Long> country2LocaleCount = Stream.of(Locale.getAvailableLocales())
			.collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));

	// similar to: select sum(population) from city group by state;
	public static class City {
		private String name;
		private String state;
		private int population;

		public String getState() {
			return state;
		}

		public int getPopulation() {
			return population;
		}

		public String getName() {
			return name;
		}

		public City(String name, String state, int population) {
			this.name = name;
			this.state = state;
			this.population = population;
		}
	}

	static Map<String, Integer> state2CityPopulation = Stream
			.of(new City("chicago", "Illinois", 860), new City("New York", "New York", 1200),
					new City("Springfield", "Illinois", 120))
			.collect(Collectors.groupingBy(City::getState, Collectors.summingInt(City::getPopulation)));

	// similar to : select state, max(population) from city group by state;

	static Map<String, Optional<City>> state2LargestCity = Stream
			.of(new City("chicago", "Illinois", 860), new City("New York", "New York", 1200),
					new City("Springfield", "Illinois", 120))
			.collect(
					Collectors.groupingBy(City::getState, Collectors.maxBy(Comparator.comparing(City::getPopulation))));

	// similar to : select state,max(len(name)) from city group by state ;
	static Map<String, Optional<String>> state2LongestCityName = Stream
			.of(new City("chicago", "Illinois", 860), new City("New York", "New York", 1200),
					new City("Springfield", "Illinois", 120))
			.collect(Collectors.groupingBy(City::getState,
					Collectors.mapping(City::getName, Collectors.maxBy(Comparator.comparing(String::length)))));

	static Map<Object, Set<Object>> country2Languages = Stream.of(Locale.getAvailableLocales()).collect(Collectors
			.groupingBy(Locale::getDisplayCountry, Collectors.mapping(Locale::getDisplayLanguage, Collectors.toSet())));

	// summary
	static Map<String, IntSummaryStatistics> state2CityPopulationSummary = Stream
			.of(new City("chicago", "Illinois", 860), new City("New York", "New York", 1200),
					new City("Springfield", "Illinois", 120))
			.collect(Collectors.groupingBy(City::getState, Collectors.summarizingInt(City::getPopulation)));

	// reduce
	static Map<String, String> state2CityNames = Stream
			.of(new City("chicago", "Illinois", 860), new City("New York", "New York", 1200),
					new City("Springfield", "Illinois", 120))
			.collect(Collectors.groupingBy(City::getState,
					Collectors.reducing("", City::getName, (s, t) -> s.length() == 0 ? t : s + "," + t)));

}
