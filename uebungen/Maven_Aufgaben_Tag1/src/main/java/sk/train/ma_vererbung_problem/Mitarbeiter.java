package sk.train.ma_vererbung_problem;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Mitarbeiter {
	
	//statische Elemente
	private static int zaehler = 100_000;
	
	//Datenattribute
	private String persnr;
	private String vorname;
	private String nachname;
	private LocalDate gebdatum;
	private LocalDate einstdatum;
	private BigDecimal gehalt;


	//Konstruktoren
	public Mitarbeiter(String vorname, String nachname, LocalDate gebdatum, 
			           LocalDate einstdatum, BigDecimal gehalt) {
		super();
		this.persnr = "PO"+zaehler;
		++zaehler;
		this.vorname = vorname;
		this.nachname = nachname;
		this.gebdatum = gebdatum;
		this.einstdatum = einstdatum;
		this.gehalt = gehalt;
		
	}
	
	public Mitarbeiter(String persnr, String vorname, String nachname, LocalDate gebdatum, 
			           LocalDate einstdatum) throws Exception {
		this(vorname, nachname, gebdatum, einstdatum, new BigDecimal(2000));
	}


	//Getter/Setter
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

	public String getPersnr() {
		return persnr;
	}

	public LocalDate getGebdatum() {
		return gebdatum;
	}

	public LocalDate getEinstdatum() {
		return einstdatum;
	}
	
	public BigDecimal getGehalt() {
		return gehalt;
	}
	
	public void setGehalt(BigDecimal gehalt) {
		this.gehalt =gehalt;
	}
	
	
	//�berschriebene Standardmethoden

	@Override
	public String toString() {
		return "Mitarbeiter [persnr=" + persnr + ", vorname=" + vorname + ", nachname=" + nachname + ", gebdatum="
				+ gebdatum + ", einstdatum=" + einstdatum + ", gehalt=" + gehalt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((einstdatum == null) ? 0 : einstdatum.hashCode());
		result = prime * result + ((gebdatum == null) ? 0 : gebdatum.hashCode());
		result = prime * result + ((gehalt == null) ? 0 : gehalt.hashCode());
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((persnr == null) ? 0 : persnr.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
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
		if (einstdatum == null) {
			if (other.einstdatum != null)
				return false;
		} else if (!einstdatum.equals(other.einstdatum))
			return false;
		if (gebdatum == null) {
			if (other.gebdatum != null)
				return false;
		} else if (!gebdatum.equals(other.gebdatum))
			return false;
		if (gehalt == null) {
			if (other.gehalt != null)
				return false;
		} else if (!gehalt.equals(other.gehalt))
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (persnr == null) {
			if (other.persnr != null)
				return false;
		} else if (!persnr.equals(other.persnr))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
	


}
