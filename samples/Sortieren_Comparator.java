package sk.train;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Sortieren_Comparator {

	public static void main(String[] args) {
		ArrayList<Person> plist = new ArrayList<>();
		plist.add(new Person("p1", LocalDate.of(2025, 1, 1), 5));
		plist.add(new Person("p2", LocalDate.of(2025, 1, 31), 2));
		plist.add(new Person("p3", LocalDate.of(2025, 1, 3), 7));
		
		ArrayList<Mitarbeiter> mlist = new ArrayList<>();
		mlist.add(new Mitarbeiter ("m1", LocalDate.of(2025, 4, 5), 12, BigDecimal.TWO));
		mlist.add(new Mitarbeiter ("m21", LocalDate.of(2025, 11, 5), 4, BigDecimal.TEN));
	}

}


class Person {
	private String name;
	private LocalDate geb;
	private int nummer;
	
	public Person(String name, LocalDate geb, int nummer) {
		super();
		this.name = name;
		this.geb = geb;
		this.nummer = nummer;
	}

	public String getName() {
		return name;
	}

	public LocalDate getGeb() {
		return geb;
	}

	public int getNummer() {
		return nummer;
	}
}

class Mitarbeiter extends Person {
	
	private BigDecimal gehalt;

	public Mitarbeiter(String name, LocalDate geb, int nummer, BigDecimal gehalt) {
		super(name, geb, nummer);
		this.gehalt = gehalt;
	}

	public BigDecimal getGehalt() {
		return gehalt;
	}
	
	
	
}