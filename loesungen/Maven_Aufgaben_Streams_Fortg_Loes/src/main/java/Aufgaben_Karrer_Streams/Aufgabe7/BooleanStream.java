package Aufgaben_Karrer_Streams.Aufgabe7;

import java.util.AbstractList;
import java.util.List;
import java.util.stream.Stream;

public class BooleanStream {
	
	public static void main(String[] args) {
		
		boolean[] barray = generateBooleanArray(10);

		/*Dummerweise gibt es keinen primitiven Stream für boolean
		 * und auch keine passende Methode in der Arrays-Klasse um eine Boolean-Stream 
		 * anhand eines boolean[] zu erzeugen
		 */
		
		//Wie könnten wir also einen Stream zu dem Array erzeugen?
		//(sofern wir nicht per Hand in eine Collection kopieren wollen)
		
		
		
		//Möglichkeit 1: java.util.stream.Stream.Builder
		Stream.Builder<Boolean> builder = Stream.builder();
		for (int i = 0; i < barray.length; ++i) {
			builder.add(barray[i]);
		}
		Stream<Boolean> stream = builder.build();
		//stream.forEach(System.out::println);
		
		
		//Möglichkeit 2: Wrap via AbstractList (z.B. mit anonymer innerer Klasse)
		List<Boolean> wrapper = new AbstractList<Boolean>() {

			@Override
			public Boolean get(int index) {
				return barray[index];
			}

			@Override
			public int size() {
				return barray.length;
			}			
		};
		stream = wrapper.stream();
		stream.forEach(System.out::println);
		
		
		//not todo
		//Möglichkeit 3: Eigene Stream-Implementierung (fortgeschritten!)		
		
	}
	
	/*
     * Feld erzeugen mit zufälliger Mischung aus true und false
     * (jeder 10. Wert ist true)
     */
	private static boolean[] generateBooleanArray(int dimension) {
		boolean[] array = new boolean[dimension];
		for (int i = 0; i < dimension; i++) {
			if (Math.random() < 0.1)
				array[i] = true;
			else
				array[i] = false;
		}
		return array;
	}

}
