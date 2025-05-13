package sk.train.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Mitarbeiter implements Comparable<Mitarbeiter> {

	// abstrakte Vorgabe
	public abstract BigDecimal getGehalt();

	// Datenattribute
	private int persnr;
	private String vorname;
	private String nachname;
	private LocalDate gebdatum;
	private LocalDate einstdatum;
	private Geschlecht geschlecht;

	// Konstruktoren
	public Mitarbeiter(int persnr, String vorname, String nachname, LocalDate gebdatum, LocalDate einstdatum,
			Geschlecht geschlecht) {
		super();
		this.persnr = persnr;
		this.vorname = vorname;
		this.nachname = nachname;
		this.gebdatum = gebdatum;
		this.einstdatum = einstdatum;
		this.geschlecht = geschlecht;
	}

	// Getter/Setter
	public int getPersnr() {
		return persnr;
	}

	public void setPersnr(int persnr) {
		this.persnr = persnr;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public LocalDate getGebdatum() {
		return gebdatum;
	}

	public void setGebdatum(LocalDate gebdatum) {
		this.gebdatum = gebdatum;
	}

	public LocalDate getEinstdatum() {
		return einstdatum;
	}

	public void setEinstdatum(LocalDate einstdatum) {
		this.einstdatum = einstdatum;
	}

	public Geschlecht getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}

	// Überschriebene Standardmethoden
	

	@Override
	public int hashCode() {
		return Objects.hash(einstdatum, gebdatum, geschlecht, nachname, persnr, vorname);
	}

	@Override
	public String toString() {
		return "Mitarbeiter [persnr=" + persnr + ", vorname=" + vorname + ", nachname=" + nachname + ", gebdatum="
				+ gebdatum + ", einstdatum=" + einstdatum + ", geschlecht=" + geschlecht + ", gehalt="
				+ getGehalt() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mitarbeiter other = (Mitarbeiter) obj;
		return Objects.equals(einstdatum, other.einstdatum) && Objects.equals(gebdatum, other.gebdatum)
				&& geschlecht == other.geschlecht && Objects.equals(nachname, other.nachname) && persnr == other.persnr
				&& Objects.equals(vorname, other.vorname);
	}

	@Override
	public int compareTo(Mitarbeiter other) {
		return this.getGehalt().compareTo(other.getGehalt());
	}
	
}
