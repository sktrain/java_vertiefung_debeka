package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.train_inheritance.InstrumentedHashSetHasA;

class InstrumentedHashSetHasA_Test {

	private InstrumentedHashSetHasA<String> ihs;
	
	@BeforeEach
	void setUp() throws Exception {
		ihs = new InstrumentedHashSetHasA<String>();
	}

	@Test
	void testAdd() {
		ihs.add("Hallo");
		assertEquals(1, ihs.getAddCount(), "Falsche Anzahl");
	}

	@Test
	void testAddAll() {
		ihs.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
		assertEquals(3, ihs.getAddCount(),"Falsche Anzahl");
	}
	
	@Test
	void testContains() {
		ihs.addAll(Arrays.asList("Snap", "Crackle", "Pop")); 
		assertTrue(ihs.containsAll(Arrays.asList("Snap", "Crackle", "Pop")));
	}

}
