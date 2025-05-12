package arrays;

import java.util.Arrays;

public class TestArrays {

	public static void main(String[] args) {
		
		//Arrays sind Objekte		
		int[] iarray = null;
		iarray = new int[10];  //Arrays mit Primitiven sind bereits initialisiert
		System.out.println(iarray[1]);
		iarray[0] = 1;
		
		//Arrays von Objekten: die eigentlichen Objekte müssen erst aufgebaut werden
		String [] strings = new String[5];
		//z.B. via Füllschleife
		for (int i = 0; i < strings.length; i++) {
			strings[i] = "Hallo" + i;
		}

		if (strings[0] != null) {
			System.out.println(strings[0].toUpperCase());
		}
		
		//z.B. durch direkte Array-Initialisierung
		String[] stringsb = { "Hallo" + 1, "Hallo" + 2, "Hugo" + 5 };

		int[] ibarray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		System.out.println(iarray.getClass());
		System.out.println(strings.getClass());
		
		//Verschiedene Möglichkeiten der Iteration

		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}

		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++\n");

		for (String v : strings) {
			System.out.println(v);
		}

		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println(Arrays.toString(strings));

		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		//via Lambda ab Java 8
		Arrays.asList(strings).forEach(s -> System.out.println(s));

	}

}
