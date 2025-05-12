package oo;
interface FlaecheBerechnen{
	double flaeche();
}

public class OuterClassWithAnonymous {
	
	private class Inner {
		private int i = 1;
	}
	
	FlaecheBerechnen print(){
		Inner in = new Inner();
		System.out.println(in.i);
		
		FlaecheBerechnen anonyminner = new FlaecheBerechnen()
		{
			public double flaeche(){
				return 0.0;}
		};
		System.out.println(anonyminner.flaeche());
		return anonyminner;
	}
	

	
	public static void main(String[] args){
		OuterClassWithAnonymous oc = new OuterClassWithAnonymous();
		FlaecheBerechnen f = oc.print();
		System.out.println(f.flaeche());
	}
}
