package Aufgaben_6_13;

import java.util.ArrayList;
import java.util.List;

public class Aufgabe_2 {
	
	public static void main(final String[] args) {
		List<Person> persons = createDemoData();

		final Person person1 = findPersonByName(persons, "unknown");
		processPerson(person1);
		final Person person2 = findPersonByName(persons, "Micha");
		processPerson(person2);
	}

	private static void processPerson(final Person person) {
		if (person != null) {
			System.out.println(person);
		} else {
			System.out.println("No person found!");
		}
	}

	private static Person findPersonByName(final List<Person> persons, final String desired) {
		for (final Person person : persons) {
			if (person.getName().equals(desired)) {
				return person;
			}
		}
		return null;
	}

	private static List<Person> createDemoData() {
		final List<Person> persons = new ArrayList<>();
		persons.add(new Person("Michael", 43));
		persons.add(new Person("Max", 5));
		persons.add(new Person("Moritz", 7));
		persons.add(new Person("Merten", 38));
		persons.add(new Person("Micha", 42));
		return persons;
	}

}
