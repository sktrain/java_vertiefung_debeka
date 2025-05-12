package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import sk.train_memory.Person_old;

class Person_old_Test {
	
	
	static Stream<Date> birthDateProvider1(){			
		return Stream.of(new Date(46, 0, 1, 0, 0, 1), new Date(61, 11, 1, 0, 0, 0), new Date(64, 11, 31, 23, 59, 59));
	}
	
	static Stream<Date> birthDateProvider2(){			
		return Stream.of(new Date(45, 0, 1, 0, 0, 1), new Date(65, 11, 1, 0, 0, 0), new Date(104, 11, 31, 23, 59, 59));
	}

	
	@Disabled
	@Test
	void testIsBabyBoomer() {
		Date birthdate = new Date(46, 0, 1, 0, 0, 0);
		assertTrue(new Person_old(birthdate).isBabyBoomer(), "comparison not correct");
	}
	
	@Disabled
	@Test //schlägt auch fehl, da die Berechnung via static-Variante wiederum anders ist!!
	void testIsBabyBoomerCalendar() {
		var cal = Calendar.getInstance();
		cal.set(1946, 0, 1, 0, 0, 0);
		Date birthdate = cal.getTime();
		System.err.println(birthdate.getTime());
		assertTrue(new Person_old(birthdate).isBabyBoomer(), "comparison not correct");
	}
	
	
	@ParameterizedTest
	@MethodSource("birthDateProvider1")
	void testIsBabyBoomerMany(Date birthdate) {
		assertTrue(new Person_old(birthdate).isBabyBoomer());
	}
	
	@ParameterizedTest
	@MethodSource("birthDateProvider2")
	void testIsNotBabyBoomerMany(Date birthdate) {
		assertFalse(new Person_old(birthdate).isBabyBoomer());
	}

}
