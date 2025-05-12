package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import sk.train.ma_vererbung.Arbeiter;
import sk.train.ma_vererbung.FixGehaltMitarbeiter;
import sk.train.ma_vererbung.Mitarbeiter;

class Mitarbeiter_Test {

		
	@Test
	void testMitarbeiterGehalt() {
		Mitarbeiter m = new FixGehaltMitarbeiter("Erika", "Musterfrau", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
                new BigDecimal(5000));
		assertEquals(new BigDecimal(5000), m.getGehalt(), "gehalt ist nicht korrekt");
		((FixGehaltMitarbeiter) m).setGehalt(BigDecimal.TEN);
		assertEquals(BigDecimal.TEN, m.getGehalt(), "gehalt ist nicht korrekt");	
	}

	@Test
	void testArbeiterGehalt() {
		Arbeiter a = new Arbeiter("Max", "Maulwurf", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
                new BigDecimal("17.25"), new BigDecimal(100));
		assertEquals(new BigDecimal("17.25").multiply(new BigDecimal(100)), a.getGehalt(), "gehalt ist nicht korrekt");
		a.setStdlohn(BigDecimal.TEN);
		assertEquals(BigDecimal.TEN.multiply(a.getStdzahl()), a.getGehalt(), "gehalt ist nicht korrekt");	
	}

	@Test
	void testGehalt2() {
		Arbeiter a = new Arbeiter("Max", "Maulwurf", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
                new BigDecimal("17.25"), new BigDecimal(100));
		
		a.setStdzahl(BigDecimal.TEN);
		assertEquals(BigDecimal.TEN.multiply(new BigDecimal("17.25")), a.getGehalt(), "gehalt ist nicht korrekt");
	}
	
	@Test
	void testEquals() {
		Mitarbeiter a = new Arbeiter("Max", "Maulwurf", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
                new BigDecimal(50), new BigDecimal(100));
		Mitarbeiter m = new FixGehaltMitarbeiter("Max", "Maulwurf", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
                new BigDecimal(5000));
		assertFalse(a.equals(m));
	}

}
