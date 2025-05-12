package sk.train.ma.strategyfactory;

import java.math.BigDecimal;

//ab Java 8 möglich: Factory Method direkt im Interface
public interface Gehaltsmodell {
	
	public abstract BigDecimal getGehalt();
	
	public static Gehaltsmodell getGehaltsmodell(String type) {
		if (type.equals("A"))
			return new ArbeiterModell(new BigDecimal((int)(Math.random()*100)),
  					new BigDecimal(120));
		else
			return new FixGehaltModell(new BigDecimal((int)(Math.random()*10000)));
	}

}
