package Aufgaben_3_9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Aufgabe_1_loes {

	public static void main(String[] args) {

		final String[] namesArray = { "Tim", "Tom", "Andy", "Mike", "Merten" };
		final List<String> names = Arrays.asList(namesArray);
		
		final Stream<String> streamFromArray = Arrays.stream(namesArray);	
		final Stream<String> streamFromList = names.stream();	
		final Stream<String> streamFromValues = Stream.of("Tim", "Tom", "Andy", "Mike", "Merten");	
		
		
		final Stream<String> filtered = streamFromList.filter(name -> name.charAt(0) == 'T');
		//folgende Variante liefert Exception, da der Stream bereits verwendet wurde
		//final Stream<String> mapped = streamFromList.map(String::toUpperCase);
		final Stream<String> mapped = streamFromValues.map(String::toUpperCase);
		
		//Test
    	filtered.forEach(System.out::println);
        mapped.forEach(System.out::println);
//		
//		//mal kombiniert
    	names.stream().filter(name -> name.charAt(0) == 'T').map(String::toUpperCase).forEach(System.out::println);

	}

}
