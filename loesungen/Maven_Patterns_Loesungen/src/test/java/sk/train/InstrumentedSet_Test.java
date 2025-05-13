package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.train.instrumentedHashSet_Decorator.InstrumentedSet;

class InstrumentedSet_Test {

	private InstrumentedSet<String> is;
	
	@BeforeEach
	void setUp() throws Exception {
		is = new InstrumentedSet<String>(new HashSet<String>());
	}

	@Test
	void testAdd() {
		is.add("Hallo");
		assertEquals(1, is.getAddCount(), "Falsche Anzahl");
	}

	@Test
	void testAddAll() {
		is.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
		assertEquals(3, is.getAddCount(),"Falsche Anzahl");
	}
	
	@Test
	void testContains() {
		is.addAll(Arrays.asList("Snap", "Crackle", "Pop")); 
		assertTrue(is.containsAll(Arrays.asList("Snap", "Crackle", "Pop")));
	}

}
