package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	private Calculator c = new Calculator();

	@Test
	void testAdd() {
		System.out.println(c);
		assertEquals(4, c.add(2, 2), "fehlerhafte Addition");
	}

	@Test
	@Disabled
	void testMult() {
		System.out.println(c);
		// Lazily evaluates supplier
		assertEquals(100_000, c.mult(100_000, 100_000)/100_000, () -> "fehlerhafte Multiplikation");
	}
	
	@Test
	@Disabled
	void groupedAssertions() {
		// In a grouped assertion all assertions are executed, and all
		// failures will be reported together.
		assertAll("calculator_all",
			() -> assertEquals(5, c.add(2, 2), "fehlerhafte Addition"),
			() -> assertEquals(100_000, c.mult(100_000, 100_000)/100_000, () -> "fehlerhafte Multiplikation")
		);
	}
	
	@Test  
	@Disabled
	void testDoubleSum() {
		// Delta with Floatingpoint
		double result = 0.1 + 0.1 + 0.1  + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
		Assertions.assertEquals(1.0, result , 0.0, "Nicht ok");
	}

	@Test
	void testFakultaet() {
		assertEquals(1, c.fakultaet(1), "Nicht ok");
		assertEquals(120, c.fakultaet(5), "Nicht ok");
	}

	// Exceptions testen
	@Test
	void testFakExact() {
		assertEquals(1, c.fakultaetExact(1), "Nicht ok");
		assertEquals(120, c.fakultaetExact(5), "Nicht ok");
		assertThrows(ArithmeticException.class, () -> c.fakultaetExact(13));	
	}

}
