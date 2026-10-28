package musiker.beans;


import musiker.annos.KlavierType;
import musiker.ifaces.Instrument;

@KlavierType
public class Klavier implements Instrument{
	
	public Klavier(){
		super();
	}
	
	public void play() {
		System.out.println("Klavierklänge von " + this);
	}
}

