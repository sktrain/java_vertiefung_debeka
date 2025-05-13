package Aufgaben_3_8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Aufgabe_5_loes {
	
	private static Predicate<String> isShortWord = s -> s.length() < 4;

	public static void main(String[] args) {
		
		System.out.println(removeIf_Internal());
		
		System.out.println(removeIf_General(s -> s.equals("Michael")));

	}
	
	private static List<String> removeIf_Internal() {
		final List<String> names = createNamesList();
		names.removeIf(isShortWord);
		return names;
	}
	
	//allgemeinere Variante
	private static List<String> removeIf_General(Predicate<String> p) {
		final List<String> names = createNamesList();
		names.removeIf(p);
		return names;
	}
	
	private static List<String> removeIf_External_Iteration() {
		final List<String> names = createNamesList();
		final Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			final String currentName = it.next();
			if (currentName.length() < 4) {
				it.remove();
			}
		}
		return names;
	}

	private static List<String> createNamesList() {
		final List<String> names = new ArrayList<>();
		names.add("Michael");
		names.add("Tim");
		names.add("Flo");
		names.add("Clemens");
		return names;
	}

}
