package Aufgaben_6_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aufgabe_1_loes {

	public static void main(final String[] args) {
		
		final List<String> names = createNamesList();
		
		final Comparator<String> byLength = new Comparator<String>() {
			@Override
			public int compare(final String str1, final String str2) {
				return Integer.compare(str1.length(), str2.length());
			}
		};
		
		//das wäre die bisherige Lambda-Variante
		Comparator<String> lengthComp = (String s1, String s2) -> s1.length()-s2.length();
		
		//1a
		//hier jetzt die Variante mit der statischen comparing-Methode
		Collections.sort(names, Comparator.comparing(String::length));
		System.out.println(names);
		
		//1b
		Collections.sort(names, 
				Comparator.comparing((String s) -> s.length())
				                      .thenComparing(Comparator.naturalOrder()));
		System.out.println(names);
		
		//1c 
		Collections.sort(names, 
				Comparator.comparing((String s) -> s.length()).reversed()
				                      .thenComparing(Comparator.naturalOrder()));
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
