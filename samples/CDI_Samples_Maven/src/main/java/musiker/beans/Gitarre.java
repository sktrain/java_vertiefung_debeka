package musiker.beans;

import musiker.annos.GitarreType;
import musiker.ifaces.Instrument;

@GitarreType
public class Gitarre implements Instrument{
	
	public Gitarre(){
		super();
	}
	
	public void play() {
		System.out.println("Gitarrenklänge");
	}
}