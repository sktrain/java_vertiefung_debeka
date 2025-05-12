package procedural;

import javax.swing.*;
import java.math.BigInteger;

/* Verschiedene Varianten der Fakultätsfunktion:
 * Berechnung der Fakultätswerte von 1 bis n,
 * wobei n dem Programm als Parameter übergeben wird */

public class Fakultaet {

	public static void main(String[] args) {
		/* Initialisierung von n */
		int n =1;
		
		/* Falls n beim Aufruf übergeben wird */
		if (args.length > 0){
			try {
				n = Integer.parseInt(args[0]);
				/* Aufruf der iterative Variante auf Basis von int */
				System.out.println("------- Fakultät von 1 bis n mit int --------------");
				for (int i = 1; i <= n; ++i){
					System.out.println(i+ " :  " + fak1(i));
				}
			} catch (NumberFormatException e) {
				System.err.println("Keine korrekte Zahl eingegeben");
			}
			return; //Ausstieg aus dem Programm
		}
		
		/* Falls n über GUI-Dialog gelesen werden soll */
		String eingabe = "";
		while (true){  //Benutzer wird solange zur Eingabe aufgefordert, bis Ganzzahl eingeben wird
			eingabe = JOptionPane.showInputDialog("Bitte positive Ganzzahl eingeben");
			
			try {
				n = Integer.parseInt(eingabe);
				break;
			}
			catch (NumberFormatException e) {
			  System.err.println("Das war nix: "+e.getMessage());
			}/*catch (Exception e){
				
			}*/
		}
		/* Aufruf der rekursiven Variante der Fakultätsberechnung auf Basis von int
		 * und Ausgabe der Ergebnisse auf der Standardausgabe 
		*/System.out.println("------- Fakultät von 1 bis n mit int --------------");
		for (int i = 1; i <= n; ++i){
			System.out.println(i+ " :  " + fak2(i));
		}
		/* Alternative Ausgabe der Ergebnisse mittels Dialogfenster 
		String[] output = new String[n+1];
		output[0] = "------- Fakultät von 1 bis n mit int --------------";
		for (int i = 1; i <= n; ++i){
			output[i] = (i+ " :  " + fak2(i));
		}
		JOptionPane.showMessageDialog(null, output, "Fakultätsberechnung", JOptionPane.INFORMATION_MESSAGE);*/
		
		// Aufruf der Variante auf Basis von BigInteger
		/*System.out.println("------- Fakultät von 1 bis n mit BigInteger --------------");
		BigInteger n1= BigInteger.ONE;
		n1 = new BigInteger(eingabe);
		for (BigInteger i = BigInteger.ONE; n1.compareTo(i) >= 0; i=i.add(BigInteger.ONE)){
			System.out.println(i+ " :  " + fak3(i));
		}*/
	}
	
	
	/* Iterative Variante der Fakultätsberechnung auf Basis int  */
	public static int fak1(int n){
		int result = 1;
		for(int i = 1; i <= n; ++i){
			result = result * i;
		}
		return result;
	}
	
	/* Rekursive Variante der Fakultätsberechnung auf Basis int  */
	public static int fak2(int i){
		if (i == 1){
			return 1;
		} else{
			return(i * fak2(--i));
		}
	}
		
	/* Iterative Variante der Fakultätsberechnung auf Basis BigInteger */
	public static BigInteger fak3(BigInteger n){
		BigInteger result = BigInteger.ONE;
		for(BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0;  i = i.add(BigInteger.ONE) ){
			result = result.multiply(i);
		}
		return result;
	}
	
	
	/* Ende der Klasse */
}
