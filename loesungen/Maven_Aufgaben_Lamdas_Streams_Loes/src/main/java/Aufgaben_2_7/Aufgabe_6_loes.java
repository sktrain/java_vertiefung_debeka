package Aufgaben_2_7;

public class Aufgabe_6_loes implements IF1, IF2 {

	//z.B. Entscheidung für die Methode aus IF2
	/*
	 * @Override public void sameMethod() { IF2.super.sameMethod(); }
	 */
	
	//Alternativ: eigene Implememtierung
	@Override
	public void sameMethod() {
		System.out.println("Conflict");
	}

}

interface IF1{
	default void sameMethod() {
		System.out.println("IF1");
	}
}

interface IF2{
	default void sameMethod() {
		System.out.println("IF2");
	}
}
