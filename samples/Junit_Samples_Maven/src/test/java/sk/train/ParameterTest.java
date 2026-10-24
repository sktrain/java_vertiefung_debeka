package sk.train;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.FieldSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterTest {
	
	private Calculator c = new Calculator();
	
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void testRange(int argument) {
		assertTrue(argument > 0 && argument < 4);
	}
	
	@ParameterizedTest
	@CsvSource({
	    "1, 1",
	    "2, 2",
	    "3,	6",
	    "4,	24",
	    "5, 120"
	})
	void testFakultaetWithCSVSource(int argument, int expected) {
		System.out.println("arg=" + argument + "\t" + "exp=" + expected);
		assertEquals(expected, c.fakultaet(argument));
	}
	
	
	
	@ParameterizedTest
	@FieldSource("listOfStrings")
	void singleFieldSource(String s) {
		assertTrue(s.length()<20);
	}

	static final List<String> listOfStrings = Arrays.asList("apple", "banana");
	
	
	
	@ParameterizedTest
	@MethodSource("stringProvider")
	void testWithExplicitLocalMethodSource(String argument) {
		assertNotNull(argument);
	}

	static Stream<String> stringProvider() {
		return Stream.of("apple", "banana");
	}
	
	
	
	@ParameterizedTest
	@MethodSource("stringIntAndListProvider")
	void testWithMultiArgMethodSource(String str, int num, List<String> list) {
		assertEquals(5, str.length());
		assertTrue(num >=1 && num <=2);
		assertEquals(2, list.size());
	}

	static Stream<Arguments> stringIntAndListProvider() {
		return Stream.of(
			Arguments.arguments("apple", 1, Arrays.asList("a", "b")),
			Arguments.arguments("lemon", 2, Arrays.asList("x", "y"))
		);
	}

}
