package Aufgaben_2_7;

public class Aufgabe_2_loes {

	public static void main(String[] args) throws InterruptedException {
		
		//2a
		Runnable runner = () -> {
			System.out.println("I say Hello ...");
		};		
	    new Thread(runner).start();
		
	    //2b
		final String s = "Huhu";

		runner = () -> {
			
			System.out.println(s);
		};
		new Thread(runner).start();
		
		
	    //2c
		new Thread(produce("Produce")).start();
		
	}
	
	public static Runnable produce(String p) {
		return () -> System.out.println(p);
	}
	
	

}
