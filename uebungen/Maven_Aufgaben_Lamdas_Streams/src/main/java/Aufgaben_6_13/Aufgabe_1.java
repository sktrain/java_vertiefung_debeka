package Aufgaben_6_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aufgabe_1 {

	public static void main(final String[] args) {
		
		final List<String> names = createNamesList();
		
		final Comparator<String> byLength = new Comparator<String>() {
			@Override
			public int compare(final String str1, final String str2) {
				return Integer.compare(str1.length(), str2.length());
			}
		};
		
		Collections.sort(names, byLength);
		System.out.println(names);
	}

	private static List<String> createNamesList() {
		final List<String> names = new ArrayList<>();
		names.add("Michael");
		names.add("Tim");
		names.add("Jörg");
		names.add("Flo");
		names.add("Andy");
		names.add("Clemens");
		return names;
	}

}
