package Aufgaben_3_8;

import java.util.Arrays;
import java.util.List;

public class Aufgabe_1_loes {

	public static void main(String[] args) {
		
		final List<String> names = Arrays.asList("Tim", "Peter", "Mike");

//		for (final String name : names) {
//			System.out.println(name);
//		}
		
		names.forEach(System.out::println);
	}

}
