package sk.train.ma_verwaltung_strategy;

import java.math.BigDecimal;

public class Arbeitermodell implements Gehaltsmodell{
	
	//Datenattribute
	private BigDecimal stdlohn;
	private BigDecimal stdzahl;
	
	
	//Konstruktoren	
	public Arbeitermodell(BigDecimal stdlohn, BigDecimal stdzahl) {
		super();
		this.stdlohn = stdlohn;
		this.stdzahl = stdzahl;
	}

	//getter/setter
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
	public String toString() {
		return "Arbeitermodell [getStdlohn()=" + getStdlohn() + ", getStdzahl()=" + getStdzahl() + ", getGehalt()="
				+ getGehalt() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stdlohn == null) ? 0 : stdlohn.hashCode());
		result = prime * result + ((stdzahl == null) ? 0 : stdzahl.hashCode());
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
		Arbeitermodell other = (Arbeitermodell) obj;
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
