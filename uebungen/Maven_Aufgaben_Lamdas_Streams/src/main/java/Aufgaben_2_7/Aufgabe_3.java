package Aufgaben_2_7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aufgabe_3 {

	public static void main(String[] args) {

		final List<String> names = Arrays.asList("Josef", "JÖrg", "Jürgen");

		final Comparator<String> byLength = new Comparator<String>() {
			@Override
			public int compare(final String str1, final String str2) {
				return Integer.compare(str1.length(), str2.length());
			}
		};

		final Comparator<String> caseInsensitive = new Comparator<String>() {
			@Override
			public int compare(final String str1, final String str2) {
				return str1.compareToIgnoreCase(str2);
			}
		};
		
		Collections.sort(names, byLength);
		System.out.println(names);
		
		Collections.sort(names, caseInsensitive);
		System.out.println(names);
	}
}
