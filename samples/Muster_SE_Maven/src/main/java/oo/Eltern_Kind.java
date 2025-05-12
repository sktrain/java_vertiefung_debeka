package oo;

import static java.lang.System.out;

class Eltern1 {
	static int f0() { return 0;	}
	int f1() { return 1;	}
	int f2(Object o) { return 2;	} 
	private final int f3() { return 500; }
}

class Kind1 extends Eltern1 {
	static int f0() { return 100;}
	int f1() { return (11+super.f1()); }	//ueberschreiben
	//@Override 
	int f2(Integer i) { return 12; }	//ueberladen
	int f3 () { return 1000; }	//Definition
}

public class Eltern_Kind{
	public static void main(String args[] ){
	Kind1 k = new Kind1();
	out.println(k.f2(new Object()));
	System.out.println(k.f2(new Integer(1)));
	System.out.println(k.f3());
	System.out.println(k.f1());
	Eltern1 e1 = new Kind1();
	System.out.println(e1.f1());
	System.out.println(e1.f2(new Integer(1)));
	System.out.println(((Kind1)e1).f3());
	Eltern1 e2 = new Eltern1();
	System.out.println(e2.f1());
	//System.out.println(((Kind1)e2).f2(1));
	}
	
}