package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import sk.train.ma.strategyfactory.ArbeiterModell;
import sk.train.ma.strategyfactory.FixGehaltModell;
import sk.train.ma.strategyfactory.Gehaltsmodell;
import sk.train.ma.strategyfactory.Mitarbeiter;



class MitarbeiterStrategyFactory_Test {

		
	@Test
	void testFixGehaltMitarbeiter() {
		Mitarbeiter m = new Mitarbeiter("Erika", "Musterfrau", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
                new FixGehaltModell(new BigDecimal(5000)));
		assertEquals(new BigDecimal(5000), m.getGmodel().getGehalt(), "gehalt ist nicht korrekt");
		((FixGehaltModell) m.getGmodel()).setGehalt(BigDecimal.TEN);
		assertEquals(BigDecimal.TEN, m.getGmodel().getGehalt(), "gehalt ist nicht korrekt");	
	}

	@Test
	void testArbeiter() {
		Mitarbeiter a = new Mitarbeiter("Max", "Maulwurf", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
           new ArbeiterModell(new BigDecimal("17.25"), new BigDecimal(100)));
		assertEquals(new BigDecimal("17.25").multiply(new BigDecimal(100)), a.getGmodel().getGehalt(), "gehalt ist nicht korrekt");
		((ArbeiterModell) a.getGmodel()).setStdlohn(BigDecimal.TEN);
		assertEquals(BigDecimal.TEN.multiply(((ArbeiterModell) a.getGmodel()).getStdzahl()), a.getGmodel().getGehalt(), "gehalt ist nicht korrekt");	
	}

	@Test
	void testGehalt2() {
		Mitarbeiter a = new Mitarbeiter("Max", "Maulwurf", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
		           new ArbeiterModell(new BigDecimal("17.25"), new BigDecimal(100)));
		((ArbeiterModell) a.getGmodel()).setStdzahl(BigDecimal.TEN);
		assertEquals(BigDecimal.TEN.multiply(new BigDecimal("17.25")), a.getGmodel().getGehalt(), "gehalt ist nicht korrekt");
	}
	
	@Test
	void testChangeModell() {
		Mitarbeiter a = new Mitarbeiter("Max", "Maulwurf", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
		           new ArbeiterModell(new BigDecimal("17.25"), new BigDecimal(100)));
		a.setGmodel(new FixGehaltModell(new BigDecimal(5000)));
		assertInstanceOf(FixGehaltModell.class, a.getGmodel());
	}
	
	@Test
	void testFactoryMethod() {
		assertInstanceOf(ArbeiterModell.class, Gehaltsmodell.getGehaltsmodell("A"));
		assertInstanceOf(FixGehaltModell.class, Gehaltsmodell.getGehaltsmodell("F"));
	}
	
	//.. weitere Testfälle

}
