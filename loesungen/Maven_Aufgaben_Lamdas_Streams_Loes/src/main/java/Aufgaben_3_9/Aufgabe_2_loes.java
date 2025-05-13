package Aufgaben_3_9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aufgabe_2_loes {

	public static void main(String[] args) {

		final String[] namesArray = { "Tim", "Tom", "Andy", "Mike", "Merten" };
		final List<String> names = Arrays.asList(namesArray);
		
		final Stream<String> streamFromArray = Arrays.stream(namesArray);	
		final Stream<String> streamFromValues = names.stream();	
		
		// ... TODO ...
		final Object[] contentsAsArray = streamFromArray.toArray();
		final List<String> contentsAsList = streamFromValues.collect(Collectors.toList());
		
		//nur zum Test
		System.out.println(Arrays.toString(contentsAsArray));
		System.out.println(contentsAsList);
		

	}

}