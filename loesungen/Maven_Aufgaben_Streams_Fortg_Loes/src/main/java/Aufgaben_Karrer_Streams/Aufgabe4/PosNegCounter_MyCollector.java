/*	Berechnung der Anzahl der positiven, negativen und 0-Werte in einem gegebenen Array mittels 
 *  eines Stream-Durchlaufs und selbstgeschriebenem Collector * 
 */

package Aufgaben_Karrer_Streams.Aufgabe4;

import java.util.stream.IntStream;

public class PosNegCounter_MyCollector {

	public static void main(String[] args) {

     MySupplier s =  IntStream.of(1, -2, 4, 5, 7, -8, 0).collect( MySupplier::new,  // () -> new MySupplier()
        		                                    	        MySupplier::accu,  // (supplier, int) -> supplier.accu(i)
        		                                                MySupplier::combi);
     System.out.println(s);  
	}
}

class MySupplier{
	private long pos;
	private long neg;
	private long zero;
		
	public void accu(int i) {
		if (i <0 ) {neg++; return;}
		if (i >0 ) { pos++; return;}
		zero++;	
	}
	
	public void combi(MySupplier other) {
		pos = pos + other.pos;
		neg = neg + other.neg;
		zero = zero + other.zero;
	}
	
	public String toString() {
		return "Positiv: " + pos + "\nNegativ: " + neg + "\nZeros: " + zero;
	}
}
