package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import sk.train_memory.Person_old;

class Person_old_Test {
	
	
	static Stream<Date> birthDateProvider(){	
		
		return Stream.of(new Date(46, 0, 1, 0, 0, 1), new Date(61, 11, 1, 0, 0, 0), new Date(64, 11, 31, 23, 59, 59));
	}

	
	@Test
	void testIsBabyBoomer() {
		Date birthdate = new Date(46, 0, 1, 0, 0, 0);
		assertTrue(new Person_old(birthdate).isBabyBoomer(), "comparison not correct");
	}
	
	@Test
	void testIsBabyBoomerCalendar() {
		var cal = Calendar.getInstance();
		cal.set(1946, 0, 1, 0, 0, 0);
		Date birthdate = cal.getTime();
		assertTrue(new Person_old(birthdate).isBabyBoomer(), "comparison not correct");
	}
	
	
	@ParameterizedTest
	@MethodSource("birthDateProvider")
	void testIsBabyBoomerMany(Date birthdate) {
		assertTrue(new Person_old(birthdate).isBabyBoomer());
	}

}
