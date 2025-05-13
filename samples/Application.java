package sk.train;

class A {
	
	public String a1() { return "A:a1"; }
	
	public String a2() { return "A:a2"; }	

}

// IsA
class B extends A {
	
	public String b1() { return "B:b1"; }
	
	@Override
	public String a2() { return "B:a2 : " + super.a2(); }
}


// HasA : Delegation
class C {
	
	private A a = new A();
	
	public String b1() { return "B:b1"; }
	
	public String a2() { return "B:a2 : " + a.a2(); }
	
	public String a1() { return a.a1(); }
	
}


public class Application{
	
	public static void main(String[] args) {
		
		//Möglichkeiten von B (IsA)
		B b = new B();
		System.out.println(b.a1());
		System.out.println(b.a2());
		System.out.println(b.b1());
		
		System.out.println("\n******************************\n");
		
		//Möglichkeiten von C (HasA)
		C c = new C();
		System.out.println(c.a1());
		System.out.println(c.a2());
		System.out.println(b.b1());
		
	}
	
}