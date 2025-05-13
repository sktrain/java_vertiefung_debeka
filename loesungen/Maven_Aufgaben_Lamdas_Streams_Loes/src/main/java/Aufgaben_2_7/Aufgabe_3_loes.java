package Aufgaben_2_7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aufgabe_3_loes {

	public static void main(String[] args) {

		final List<String> names = Arrays.asList("Josef", "Jörg", "Jürgen");

		/*final Comparator<String> byLength = new Comparator<String>() {
			@Override
			public int compare(final String str1, final String str2) {
				return Integer.compare(str1.length(), str2.length());
			}
		};*/
		Comparator<String> byLength = (final String str1, final String str2) -> {
													return Integer.compare(str1.length(), str2.length());
													};
		//oder kürzer
		byLength = (str1, str2) -> Integer.compare(str1.length(), str2.length());

		
		/*
		 * final Comparator<String> caseInsensitive = new Comparator<String>() {
		 * 
		 * @Override public int compare(final String str1, final String str2) { return
		 * str1.compareToIgnoreCase(str2); } };
		 */
		Comparator<String> caseInsensitive = (str1, str2) -> str1.compareToIgnoreCase(str2);
		
		// oder kürzer als Methodenreferenz
		caseInsensitive = String::compareToIgnoreCase;
		
		
		Collections.sort(names, byLength);
		System.out.println(names);
		
		Collections.sort(names, caseInsensitive);
		System.out.println(names);
	}
}
