package sk.train.ma_verwaltung_strategy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestMitarbeiter {

	public static void main(String[] args) {

		Mitarbeiter m =new Mitarbeiter("Stephan", "Karrer", LocalDate.of(1959, 8,14), LocalDate.now(), Geschlecht.M);
		
		System.out.println(m);
		
		Arbeitermodell am = new Arbeitermodell(BigDecimal.TEN, BigDecimal.TEN);
		
		m.setModel(am);
		
		System.out.println(m);
		
		System.out.println(m.getModel().getGehalt());

	}

}
