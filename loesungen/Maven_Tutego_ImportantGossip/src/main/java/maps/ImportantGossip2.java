/* Alternative von Stephan Karrer 
 * mit Nutzung des Stream-API
 */

package maps;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImportantGossip2 {

	public static final int LIMIT = 5;

	public static List<String> importantGossip(String... words) {
		
		Map<String, Integer> wordOccurrences = new HashMap<>(words.length);
		
		/* ab Java 1.8, entspricht:
		 * V oldValue = map.get(key);
		 * V newValue = (oldValue == null) ? value : remappingFunction.apply(oldValue, value);
		 * if (newValue == null)
		 *      map.remove(key);
		 *  else
		 *  map.put(key, newValue);
		 */
		for (String word : words)
			wordOccurrences.merge(word, 1, Integer::sum);
		
		//jetzt eine Liste daraus machen mittels Stream-API
		Comparator<Map.Entry<String, Integer>> compareByWordOccurrence = Comparator
				.comparingInt((ToIntFunction<Map.Entry<String, Integer>>) Map.Entry::getValue).reversed()
				.thenComparing(Map.Entry::getKey);
		
		Stream<Map.Entry<String, Integer>> entryStream = wordOccurrences.entrySet().stream();
		List<String> collect = entryStream.sorted(compareByWordOccurrence)
		.limit(5)
		.map(entry -> entry.getKey())
		.collect(Collectors.toList());		

		return collect;
	}
	

	public static void main(String[] args) {
		String[] words = { "Baby Shark", "Corona", "Baby Yoda", "Corona", "Baby Yoda", "Tiger King", "David Bowie",
				"Kylie Jenner", "Kardashian", "Love Island", "Bachelorette", "Baby Yoda", "Tiger King", "Billie Eilish",
				"Corona" };

		// WordOccurrence a1 = new WordOccurrence( "a" );
		// WordOccurrence a2 = new WordOccurrence( "a" );
		// a2.incrementOccurrence();
		//
		// WordOccurrence b = new WordOccurrence( "b" );
		// WordOccurrence c = new WordOccurrence( "c" );
		//
		// System.out.println( a1.equals( a2 ) );
		// System.out.println( a1.compareTo( a2 ) );
		// System.out.println( a1.equals( b ) );
		// System.out.println( a1.compareTo( b ) );
		// System.out.println( a2.compareTo( b ) );

		System.out.println(importantGossip(words));
		System.out.println(importantGossip("a"));
		System.out.println(importantGossip("a", "b"));
		System.out.println(importantGossip("a", "a"));
		System.out.println(importantGossip("a", "b", "a"));
		System.out.println(importantGossip("a", "a", "a", "a", "a", "a", "a", "a"));
	}
}
