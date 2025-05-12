package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import sk.train_memory.Person;

class Person_Test {
	
	
	static Stream<LocalDate> birthDateProvider(){			
		return Stream.of(LocalDate.of(1946, 1, 1), LocalDate.of(1961, 12, 1),  LocalDate.of(1964, 12, 31));
	}
	
		
	@ParameterizedTest
	@MethodSource("birthDateProvider")
	void testIsBabyBoomerMany(LocalDate birthdate) {
		assertTrue(new Person(birthdate).isBabyBoomer());
	}

}
