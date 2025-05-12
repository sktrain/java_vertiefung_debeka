/* Was bedeutet:
 * <? extends T> bzw. <? super T>
 * 
 */
package generics;

import java.util.ArrayList;

public class GenTest {

	public static void main(String[] args) {
	
		  ArrayList<? extends Object> ao = new ArrayList<>();
		  ArrayList<Number> an = new ArrayList<>();
		  ArrayList <? super Integer> ai = new ArrayList<>();
		  
		  ao = an;
		  ai = an; 
	}

}
