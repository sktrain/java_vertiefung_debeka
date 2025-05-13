package Aufgaben_Karrer_Streams.Aufgabe2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

import sk.train.domain.Arbeiter;
import sk.train.domain.FixGehaltMitarbeiter;
import sk.train.domain.Geschlecht;
import sk.train.domain.Mitarbeiter;

public class MitarbeiterStream2 {

	public static void main(String[] args) {
		
		List<Mitarbeiter> mlist = getMitarbeiter(100);
		
		
		//TreeSet aller Namen, egal ob Vor- oder Nachname (Set enthält keine Duplikate)
		//Tip: Nutzung von flatMap
		TreeSet<String> nametree = mlist.stream()
				.map( m -> new String[] {m.getVorname(), m.getNachname()})
				.flatMap(Arrays::stream)
				.collect(Collectors.toCollection(TreeSet::new)); 
		nametree.forEach(System.out::println);
		
		
		
		//Personalnummer, Vorname, Nachname der Mitarbeiter mit dem minimalen Gehalt,
		//z.B. als Liste von String-Arrays, d.h. jedes String-Array verkörpert ein Tripel
		//(Personalnummer, Vorname, Nachname).
		//(das wird in der SQL-Welt �blicherweise als Subquery realisiert, da wir ja das Minimum kennen müssen,
		//um danach zu filtern). Da die Minimal-Wert-Bestimmung eine terminierende Operation ist, liegt auch 
		//hier nahe, zwei Streams zu nutzen.
		Optional<BigDecimal> optming = mlist.stream()
				.map(Mitarbeiter::getGehalt)
				.min(Comparator.naturalOrder()); 
		//damit haben wir das Minimum als Optional, aber Minimum existiert bei nicht leerem Stream
		BigDecimal ming = optming.isPresent() ? optming.get() : BigDecimal.ZERO; 
		System.out.println("Minimales Gehalt: " + ming);
		
		// und jetzt der zweite Stream, der danach filtert
		List<String[]> geringverdiener = mlist.stream()
				                 .filter(mitarbeiter -> mitarbeiter.getGehalt().equals(ming))
				                 .map(m -> new String[] {m.getPersnr()+"", m.getVorname(), m.getNachname()})
				                 .collect(Collectors.toList());
		System.out.println("Minimalverdiener: ");
		geringverdiener.forEach( record -> System.out.println(	record[0] + ":" 
																+ record[1] + ":"
																+ record[2] ));
		
		//bzw. gleich hübsche StringDarstellung via Collectors.joining, allerdings ohne Zeilenumbrüche
		String minverdiener = mlist.stream()
                .filter(mitarbeiter -> mitarbeiter.getGehalt().equals(ming))
                .map(m -> new String[] {m.getPersnr()+"", m.getVorname(), m.getNachname()})
                .flatMap(Arrays::stream)
                .collect(Collectors.joining(":", "Geringverdiener [", "]"));
		System.out.println(minverdiener);
		
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