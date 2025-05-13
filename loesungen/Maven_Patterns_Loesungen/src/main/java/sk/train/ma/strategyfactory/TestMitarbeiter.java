package sk.train.ma.strategyfactory;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestMitarbeiter {

	public static void main(String[] args) {

		Mitarbeiter m =new Mitarbeiter("Stephan", "Karrer", LocalDate.of(1959, 8,14), LocalDate.now());
		
		System.out.println(m);
		
		ArbeiterModell am = new ArbeiterModell(BigDecimal.TEN, BigDecimal.TEN);
		
		m.setGmodel(am);
		
		System.out.println(m);
		
		System.out.println(m.getGmodel().getGehalt());
		
		//jetzt mal Factory-Methode nutzen
		Gehaltsmodell f = Gehaltsmodell.getGehaltsmodell("F");
		
		m.setGmodel(f);
		
		System.out.println(m);
		
		System.out.println(m.getGmodel().getClass());

	}

}
