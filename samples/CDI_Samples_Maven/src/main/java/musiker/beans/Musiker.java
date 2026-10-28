package musiker.beans;


import jakarta.inject.Inject;
import musiker.annos.GitarreType;
import musiker.ifaces.Instrument;
import musiker.ifaces.Performer;

public class Musiker implements Performer{	
	
//	@Inject 
//	@GitarreType
	private Instrument i;
	
	@Inject 
	public Musiker(@GitarreType Instrument i) { this.i = i; }
	
	public void perform() {
		System.out.println("Performamce von " + this);
		i.play();
	}
}
