package Aufgaben_3_8;

import java.util.function.Predicate;

public class Aufgabe_3_loes {

	public static void main(String[] args) {

		//use class Person
		Predicate<Person> older18 = p -> p.getAge() >= 18;
		Person m = new Person("Mustermann", 17);
		System.out.println(older18.test(m));
		
		
		older18 = Person::isAdult;
		System.out.println(older18.test(m));
		Person j = new Person("John Doe", 22);
		System.out.println(older18.test(j));

	}

}
