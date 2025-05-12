package oo;


/* per static Initializer, d.h. eager */

public class EagerSingleton {
	
	private static EagerSingleton single;
	
	//static init
	{
		single = new EagerSingleton();
	}
	private EagerSingleton() {
		super();
	}
	
	static EagerSingleton getInstance(){
		return single;
	}

}
