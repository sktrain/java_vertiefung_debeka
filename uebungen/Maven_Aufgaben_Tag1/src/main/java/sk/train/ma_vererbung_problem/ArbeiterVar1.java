package sk.train.ma_vererbung_problem;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ArbeiterVar1 extends Mitarbeiter{
	
	private BigDecimal stdlohn;
	private BigDecimal stdzahl;
	
	public ArbeiterVar1(String vorname, String nachname, LocalDate gebdatum, LocalDate einstdatum, 
			BigDecimal stdlohn, BigDecimal stdzahl) {
		super(vorname, nachname, gebdatum, einstdatum, stdlohn.multiply(stdzahl));
		this.stdlohn = stdlohn;
		this.stdzahl = stdzahl;
	}

	public BigDecimal getStdlohn() {
		return stdlohn;
	}

	public void setStdlohn(BigDecimal stdlohn) {
		this.stdlohn = stdlohn;
		super.setGehalt(stdlohn.multiply(stdzahl));
	}

	public BigDecimal getStdzahl() {
		return stdzahl;
	}

	public void setStdzahl(BigDecimal stdzahl) {
		this.stdzahl = stdzahl;
		super.setGehalt(stdlohn.multiply(stdzahl));
	}
	
	

}
