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
		
		
		
		//Aufgabe: Summe der Gehälter der Arbeiter		
		
		
		
		//Aufgabe: das maximale Gehalt
		
				
				
		//Aufgabe: Anzahl Mitarbeiter je Mitarbeitertyp (FixGehalt, Arbeiter)
				
		
		
		//Aufgabe: Summe der Gehälter je Mitarbeitertyp (FixGehalt, Arbeiter)		
		
		
		
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