package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.train_inheritance.InstrumentedHashSetNotCorrect;

class InstrumentedHashSetNotCorrect_Test {

	private InstrumentedHashSetNotCorrect<String> ihs;
	
	@BeforeEach
	void setUp() throws Exception {
		ihs = new InstrumentedHashSetNotCorrect<String>();
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
