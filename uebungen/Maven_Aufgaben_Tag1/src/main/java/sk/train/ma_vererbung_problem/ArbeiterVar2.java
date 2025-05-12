package sk.train.ma_vererbung_problem;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

public class ArbeiterVar2 extends Mitarbeiter {
	
	//Datenattribute
	private BigDecimal stdlohn;
	private BigDecimal stdzahl;
	
	
	//Konstruktoren	
	public ArbeiterVar2(String vorname, String nachname, LocalDate gebdatum, LocalDate einstdatum, 
			BigDecimal stdlohn, BigDecimal stdzahl) {
		super(vorname, nachname, gebdatum, einstdatum, stdzahl.multiply(stdlohn));
		this.stdlohn = stdlohn;
		this.stdzahl = stdzahl;
	}
	
	//getter/setter
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

	@Override
	public void setGehalt(BigDecimal gehalt){
		
	}
	

}
