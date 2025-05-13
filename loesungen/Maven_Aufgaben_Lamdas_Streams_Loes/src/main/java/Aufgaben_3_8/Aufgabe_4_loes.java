package Aufgaben_3_8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aufgabe_4_loes {

	public static void main(String[] args) {
		
		final List<String> names = Arrays.asList("Tim", "Peter", "Mike", "Andy");
		
//		final Comparator<String> naturalOrder = new Comparator<String>() {
//			@Override
//			public int compare(final String str1, final String str2) {
//				return str1.compareTo(str2);
//			}
//		};
		
		//Collections.sort(names, (str1, str2) -> str1.compareTo(str2));
		
		//oder
		
		//Collections.sort(names, String::compareTo);
		
		//oder
		
		Collections.sort(names, Comparator.naturalOrder());
		
		
		
		
		for (final String name : names) {
			System.out.println(name);
		}

	}

}
