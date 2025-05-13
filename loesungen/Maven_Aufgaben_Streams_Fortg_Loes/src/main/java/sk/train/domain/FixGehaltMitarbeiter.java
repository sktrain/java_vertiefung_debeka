package sk.train.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FixGehaltMitarbeiter extends Mitarbeiter{
    
	//Datenattribute
	private BigDecimal gehalt;
	
	public FixGehaltMitarbeiter(int persnr, String vorname, String nachname, LocalDate gebdatum, LocalDate einstdatum,
			Geschlecht geschlecht, BigDecimal gehalt) {
		super(persnr, vorname, nachname, gebdatum, einstdatum, geschlecht);
		this.gehalt = gehalt;
	}

	public BigDecimal getGehalt() {
		return gehalt;
	}

	public void setGehalt(BigDecimal gehalt) {
		this.gehalt = gehalt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gehalt == null) ? 0 : gehalt.hashCode());
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
		FixGehaltMitarbeiter other = (FixGehaltMitarbeiter) obj;
		if (gehalt == null) {
			if (other.gehalt != null)
				return false;
		} else if (!gehalt.equals(other.gehalt))
			return false;
		return true;
	}	
	
}
