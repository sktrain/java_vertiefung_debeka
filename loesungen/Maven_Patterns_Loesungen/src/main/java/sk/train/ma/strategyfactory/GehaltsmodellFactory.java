package sk.train.ma.strategyfactory;

import java.math.BigDecimal;

//bis Java 7 übliche Variante: Factory Method in eigener Klasse
public class GehaltsmodellFactory {

	public static Gehaltsmodell getGehaltsmodell(String type) {
		if (type.equals("A"))
			return new ArbeiterModell(new BigDecimal((int)(Math.random()*100)),
  					new BigDecimal(120));
		else
			return new FixGehaltModell(new BigDecimal((int)(Math.random()*10000)));
	}

}
