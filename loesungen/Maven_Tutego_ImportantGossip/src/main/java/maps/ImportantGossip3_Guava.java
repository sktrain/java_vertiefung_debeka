/* MultiSet von Guava nutzen */

package maps;

import java.util.*;
import java.util.function.ToIntFunction;

import javax.swing.plaf.multi.MultiTreeUI;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.TreeMultiset;

public class ImportantGossip3_Guava {

	public static final int LIMIT = 5;

	public static List<String> importantGossip(String... words) {
		
		Multiset<String> ms = HashMultiset.create(Arrays.asList(words));
		
		ImmutableMultiset<String> ims = Multisets.copyHighestCountFirst(ms);
		
		List<String> ls = new ArrayList<>();
		for ( Entry<String> e : ims.entrySet()) {
			ls.add(e.getElement());
		}
		
		return ls;
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
//		System.out.println(importantGossip("a"));
//		System.out.println(importantGossip("a", "b"));
//		System.out.println(importantGossip("a", "a"));
//		System.out.println(importantGossip("a", "b", "a"));
//		System.out.println(importantGossip("a", "a", "a", "a", "a", "a", "a", "a"));
	}
}
