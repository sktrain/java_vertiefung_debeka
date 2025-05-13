package sk.train.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Arbeiter extends Mitarbeiter {
	
	//Datenattribute
	private BigDecimal stdlohn;
	private BigDecimal stdzahl;
	
	
	public Arbeiter(int persnr, String vorname, String nachname, LocalDate gebdatum, LocalDate einstdatum,
			Geschlecht geschlecht, BigDecimal stdlohn, BigDecimal stdzahl) {
		super(persnr, vorname, nachname, gebdatum, einstdatum, geschlecht);
		this.stdlohn = stdlohn;
		this.stdzahl = stdzahl;
	}

	public BigDecimal getStdlohn() {
		return stdlohn;
	}
	
	public void setStdlohn(BigDecimal stdlohn) {
		this.stdlohn = stdlohn;
		//super.setGehalt(stdlohn.multiply(stdzahl));
	}
	
	public BigDecimal getStdzahl() {
		return stdzahl;
	}
	
	public void setStdzahl(BigDecimal stdzahl) {
		this.stdzahl = stdzahl;
		//super.setGehalt(stdlohn.multiply(stdzahl));
	}

	@Override
	public BigDecimal getGehalt() {
		return stdlohn.multiply(stdzahl);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((stdlohn == null) ? 0 : stdlohn.hashCode());
		result = prime * result + ((stdzahl == null) ? 0 : stdzahl.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbeiter other = (Arbeiter) obj;
		if (stdlohn == null) {
			if (other.stdlohn != null)
				return false;
		} else if (!stdlohn.equals(other.stdlohn))
			return false;
		if (stdzahl == null) {
			if (other.stdzahl != null)
				return false;
		} else if (!stdzahl.equals(other.stdzahl))
			return false;
		return true;
	}	

}
