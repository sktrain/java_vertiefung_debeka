/* Berechnung des Produkts der positiven Ganzzahlen von 1 bis 100 (Fakultät)
 * und der Summe dieser Zahlen in einem Stream-Durchlauf mittels eigenem Reducer
*/

package Aufgaben_Karrer_Streams.Aufgabe5;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reduce_Sum_Fak {

	public static void main(String[] args) {

		IntStream is = IntStream.range(1, 100);
		Stream bs = is.mapToObj(i -> BigInteger.valueOf(i));
		MyReducer erg = 	//hier mal Lambda-Schreibweise statt Methodenreferenzen
				(MyReducer) bs.reduce(new MyReducer()
				                      ,(reducer, big) -> ((MyReducer) reducer).accu((BigInteger) big)
				                      ,(reducer1, reducer2) -> ((MyReducer) reducer1).combi((MyReducer) reducer2));
		System.out.println(erg);
	}
}

class MyReducer {
	private BigInteger sum = BigInteger.ZERO;
	private BigInteger fak = BigInteger.ONE;

	public MyReducer accu(BigInteger next) {
		sum = sum.add(next);
		fak = fak.multiply(next);
		return this;
	}

	public MyReducer combi(MyReducer other) {
		sum = sum.add(other.sum);
		fak = fak.multiply(other.fak);
		return this;
	}

	@Override
	public String toString() {
		return "MyReducer: sum=" + sum + "\n fak=" + fak;
	}
}
