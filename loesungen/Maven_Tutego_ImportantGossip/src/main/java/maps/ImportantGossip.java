package maps;

import java.util.*;
import java.util.function.ToIntFunction;

public class ImportantGossip {

	// tag::solution[]
	public static final int LIMIT = 5;

	public static List<String> importantGossip(String... words) {

		Map<String, Integer> wordOccurrences = new HashMap<>(words.length);
		
		/* default V 	merge​(K key, V value, BiFunction<? super V,​? super V,​? extends V> remappingFunction) 	
		 * If the specified key is not already associated with a value or is associated with null, associates it with the given non-null value.
		 * 
		 * ab Java 1.8, entspricht:
		 * V oldValue = map.get(key);
		 * V newValue = (oldValue == null) ? value : remappingFunction.apply(oldValue, value);
		 * if (newValue == null)
		 *      map.remove(key);
		 *  else
		 *  map.put(key, newValue);
		 */
		for (String word : words)
			wordOccurrences.merge(word, 1, Integer::sum);
		
		//System.out.println(wordOccurrences);
		
		//jetzt eine Liste daraus machen
		
		//Schritt 1: Comparator für die Entries, der zuerst nach der Häufigkeit und 
		//dann nach den Worten absteigend (reversed) sortiert. 
		Comparator<Map.Entry<String, Integer>> compareByWordOccurrence = Comparator
				.comparingInt((ToIntFunction<Map.Entry<String, Integer>>) Map.Entry::getValue).reversed()
				.thenComparing(Map.Entry::getKey);
		
		//Schritt 2: Umfüllen in TreeSet, der die Sortierung umsetzt
		SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>(compareByWordOccurrence);
		sortedSet.addAll(wordOccurrences.entrySet());

		//Schritt 3: Iteration über den TreeSet und füllen der Liste gemäß Sortierung
		List<String> result = new ArrayList<>(LIMIT);
		for (Map.Entry<String, Integer> element : sortedSet) {
			result.add(element.getKey());
			if (result.size() >= LIMIT)
				break;
		}

		return result;
	}
	// end::solution[]

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
