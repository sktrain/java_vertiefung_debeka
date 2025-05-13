package Aufgaben_Karrer_Streams.Aufgabe1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import sk.train.domain.Arbeiter;
import sk.train.domain.FixGehaltMitarbeiter;
import sk.train.domain.Geschlecht;
import sk.train.domain.Mitarbeiter;

public class MitarbeiterStream {

	public static void main(String[] args) {
		
		List<Mitarbeiter> mlist = getMitarbeiter(100);
		
		//Aufgabe: Summe der Gehälter aller Mitarbeiter
		BigDecimal gehaltssum = mlist.stream()
		.map(mitarbeiter -> mitarbeiter.getGehalt())
		.reduce(BigDecimal.ZERO, (summe, gehalt) -> summe.add(gehalt));
		System.out.println("Gehaltssumme: " + gehaltssum);
		
		//bzw. mit Methodenreferenzen
		gehaltssum = mlist.stream()
				.map(Mitarbeiter::getGehalt)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("Gehaltssumme: " + gehaltssum);
		
		//zur Kontrolle
//		BigDecimal gehaltssumme = BigDecimal.ZERO;
//		for (Mitarbeiter m : mlist) {
//			gehaltssumme = gehaltssumme.add(m.getGehalt());
//		}
//		System.out.println(gehaltssumme);
		
		//Aufgabe: Summe der Gehälter der Arbeiter
		BigDecimal gehaltssumArbeiter = mlist.stream()
				.filter(m -> m.getClass()==Arbeiter.class)
				.map(mitarbeiter -> mitarbeiter.getGehalt())
				.reduce(BigDecimal.ZERO, (summe, gehalt) -> summe.add(gehalt));
		System.out.println("Gehaltssumme Arbeiter: " + gehaltssumArbeiter);
		
		//bzw. mit Methodenreferenzen
		gehaltssumArbeiter = mlist.stream()
				.filter(m -> m.getClass()==Arbeiter.class)
				.map(Mitarbeiter::getGehalt)
				.reduce(BigDecimal.ZERO, (summe, gehalt) -> summe.add(gehalt));
		System.out.println("Gehaltssumme Arbeiter: " + gehaltssumArbeiter);
		
		
		//Aufgabe: das maximale Gehalt
		Optional<BigDecimal> maxgehalt = mlist.stream()
								.map(Mitarbeiter::getGehalt)
								.max(Comparator.naturalOrder());
		System.out.print("Max. Gehalt: ");
		maxgehalt.ifPresent(System.out::println);
		//bzw.
		BigDecimal maxg = mlist.stream()
				.max((m1, m2) -> m1.getGehalt().compareTo(m2.getGehalt())).get().getGehalt();
		System.out.println("Max. Gehalt: " + maxg);
		
				
				
		//Aufgabe: Anzahl Mitarbeiter je Mitarbeitertyp (FixGehalt, Arbeiter)
		Map<String, Long> map = mlist.stream()
				.collect(Collectors.groupingBy( mitarbeiter -> mitarbeiter.getClass().getSimpleName()
							, Collectors.counting()));
		System.out.println("Anzahl Mitarbeiter je Typ: \n" + map);
		
		
		
		//Aufgabe: Summe der Gehälter je Mitarbeitertyp (FixGehalt, Arbeiter)
		Map<String, BigDecimal> gehaltsmap = mlist.stream()
				.collect(Collectors.groupingBy( mitarbeiter -> mitarbeiter.getClass().getSimpleName()
							, Collectors.reducing(BigDecimal.ZERO,  //Startwert (Identity)
									              (Mitarbeiter m) -> m.getGehalt(), //Mapper
									              (BigDecimal sum, BigDecimal gehalt) -> sum.add(gehalt)) //Operator bzw. Accumulator
						                        ));
		System.out.println("Summe der Gehälter je Mitarbeitertyp: " + gehaltsmap);
		
		

		
	}


	private static List<Mitarbeiter> getMitarbeiter(int size) {

		List<Mitarbeiter> mlist = new ArrayList<Mitarbeiter>();

		Mitarbeiter m;
		for (int i = 0; i < size; ++i) {
			if (i % 2 == 0) {
				m = new FixGehaltMitarbeiter(i, "Max", "Maulwurf" + i,
					LocalDate.of(1976, 1 + (int) (Math.random() * 12), 1),
					LocalDate.of(2000 + (int) (Math.random() * 21), 1 + (int) (Math.random() * 12), 1),
					Geschlecht.M, new BigDecimal((int) (Math.random() * 10000)));
			mlist.add(m);
			} else {
				m = new Arbeiter(i, "Erika", "Musterfrau" + i, LocalDate.of(1976, 1 + (int) (Math.random() * 12), 1),
					LocalDate.of(2000 + (int) (Math.random() * 21), 1 + (int) (Math.random() * 12), 1),
					Geschlecht.W, new BigDecimal((int) (Math.random() * 100)), new BigDecimal(120));
			mlist.add(m);
			}
		}
		return mlist;
	}

}