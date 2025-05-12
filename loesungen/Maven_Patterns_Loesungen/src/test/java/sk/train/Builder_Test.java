package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.train.builder.NutritionFacts;

class Builder_Test {
	
	private NutritionFacts cocacola;

	@BeforeEach
	void setUp() throws Exception {
		cocacola = new NutritionFacts.Builder(240, 8).
	            calories(100).sodium(35).carbohydrate(27).build();		
	}
	
	@Test
	void testServingSize() {
		assertEquals(240, cocacola.getServingSize());
	}

	@Test
	void testCalories() {
		assertEquals(100, cocacola.getCalories());
	}
	
	@Test
	void testSodium() {
		assertEquals(35, cocacola.getSodium());
	}
	
	//... weitere Testfälle


}
