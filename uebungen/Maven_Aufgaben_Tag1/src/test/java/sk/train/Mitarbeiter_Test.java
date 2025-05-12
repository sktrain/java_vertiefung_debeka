package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import sk.train.ma_vererbung_problem.ArbeiterVar1;
import sk.train.ma_vererbung_problem.ArbeiterVar2;
import sk.train.ma_vererbung_problem.Mitarbeiter;

class Mitarbeiter_Test {

		
	@Test
	void testMitarbeiterGehalt() {
		Mitarbeiter m = new Mitarbeiter("Max", "Maulwurf", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
                new BigDecimal(5000));
		assertEquals(new BigDecimal(5000), m.getGehalt(), "gehalt ist nicht korrekt");
		m.setGehalt(BigDecimal.TEN);
		assertEquals(BigDecimal.TEN, m.getGehalt(), "gehalt ist nicht korrekt");	
	}

	@Test
	void testGehaltVar1() {
		ArbeiterVar1 a = new ArbeiterVar1("Max", "Maulwurf", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
                new BigDecimal("17.25"), new BigDecimal(100));
		assertEquals(new BigDecimal("17.25").multiply(new BigDecimal(100)), a.getGehalt(), "gehalt ist nicht korrekt");
		a.setGehalt(BigDecimal.TEN);
		assertEquals(BigDecimal.TEN, a.getGehalt(), "gehalt ist nicht korrekt");
		assertEquals(new BigDecimal("17.25").multiply(new BigDecimal(100)), a.getGehalt(), "gehaltsberechnung inkorrekt");		
	}

	@Test
	void testGehaltVar2() {
		ArbeiterVar2 a = new ArbeiterVar2("Max", "Maulwurf", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
                new BigDecimal("17.25"), new BigDecimal(100));
		assertEquals(new BigDecimal("17.25").multiply(new BigDecimal(100)), a.getGehalt(), "gehalt ist nicht korrekt");
		a.setGehalt(BigDecimal.TEN);
		assertEquals(BigDecimal.TEN, a.getGehalt(), "gehalt ist nicht korrekt");
		assertEquals(new BigDecimal("17.25").multiply(new BigDecimal(100)), a.getGehalt(), "gehaltsberechnung inkorrekt");
	}

}
