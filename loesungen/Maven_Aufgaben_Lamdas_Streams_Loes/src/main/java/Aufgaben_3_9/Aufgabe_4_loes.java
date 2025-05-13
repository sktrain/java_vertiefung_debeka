package Aufgaben_3_9;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aufgabe_4_loes {

	public static void main(String[] args) {

		final String[] namesArray = { "Tim", "Tom", "Andy", "Mike", "Merten" };
		final List<String> names = Arrays.asList(namesArray);
		
		//4a
		Map<Character, List<String>> s = names.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));
		//nur zum Test
		System.out.println(s);
		
		//4b
		Map<Boolean, List<String>> p = names.stream().collect(Collectors.partitioningBy(name -> name.length()<4));
		//nur zum Test
		System.out.println(p);
		
		//4c
		Map<Character, Long> c = names.stream().collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()));
		//nur zum Test
		System.out.println(c);

	}

}