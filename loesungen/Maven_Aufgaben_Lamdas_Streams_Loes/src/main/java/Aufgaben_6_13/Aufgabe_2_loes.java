package Aufgaben_6_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Aufgabe_2_loes {
	
	public static void main(final String[] args) {
		List<Person> persons = createDemoData();

//		final Person person1 = findPersonByName(persons, "unknown");
//		processPerson(person1);
//		final Person person2 = findPersonByName(persons, "Micha");
//		processPerson(person2);
		
		Optional<Person> person1 = findPersonByNameNeu(persons, "unknown");
		processPersonNeu(person1);
		person1 = findPersonByNameNeu(persons, "Micha");
		processPersonNeu(person1);
	}

	private static void processPersonNeu(final Optional<Person> person) {
	if (person.isPresent()) {
		System.out.println(person.get().getName());
	}else {
		System.out.println("No person found!");
	}
	}
	
	private static void processPerson(final Person person) {
		if (person != null) {
			System.out.println(person);
		} else {
			System.out.println("No person found!");
		}
	}
	
	private static Optional<Person> findPersonByNameNeu(List<Person> persons, String desired){
		for (final Person person : persons) {
			if (person.getName().equals(desired)) {
				return Optional.of(person);
			}
		}
		return Optional.empty();
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
