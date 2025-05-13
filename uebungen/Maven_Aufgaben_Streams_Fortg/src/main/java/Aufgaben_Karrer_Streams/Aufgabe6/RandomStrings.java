/* ersetze die Generierung des Zufalls-String durch eine Stream-Variante unter 
 * Nutzung der ints-Methode aus Random (liefert Streeam) und Collector (nutze StringBuffer)
 */
package Aufgaben_Karrer_Streams.Aufgabe6;

import java.util.Random;

public class RandomStrings {
	
	public static void main(String[] args) {
		
		System.out.println(generateRandomString());
		
		System.out.println(GeneratingRandomString_Java8());
		
	}
	
	
	
	private static String generateRandomString() {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 8;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.appendCodePoint(randomLimitedInt);
		}		
		return buffer.toString();

	}
	
	public static String GeneratingRandomString_Java8() {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 8;
	    Random random = new Random();

	    String generatedString = null;
	    //todo

	    return generatedString;
	}
	
	

}
