package Aufgaben_3_8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Aufgabe_5 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

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
