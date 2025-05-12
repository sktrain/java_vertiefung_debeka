package oo;


/*klassische Variante mit synchronized, lazy */

public class Singleton {
	
	private static Singleton singleton;
	
	private Singleton(){
		;
	}
	
	synchronized public Singleton getInstance(){
		if (singleton == null){
			singleton = new Singleton();
		} 
		return singleton;
			
	}

}
