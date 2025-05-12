//Implementierung eines Feld-Umdrehers
package arrays;

public class Umdreher {

	public static void main(String[] args) {
		double [] da = {0.1, 5.6, 7.3, 8.4};
		reverse (da);
		for (double d: da){
			System.out.println(d);
		}
		
		//jetzt die optimierte Variante
		reverseBetter (da);
		System.out.println("***************Optimierte Variante**************");
		for (double d: da){
			System.out.println(d);
		}
}
	
	public static void reverse( double[] array )
	{
	  if ( array == null )
	    return;
	  double[] hilfsarray = new double[array.length];
	  for (int i = 0; i< array.length; ++i){
		  hilfsarray[i] = array[i];
	  }
	  for (int i = array.length-1, j = 0; i >=0; --i, ++j){
		  array[j]  = hilfsarray[i];
	  }
	}
	
	public static void reverseBetter(double[] array )
	{
		if ( array == null )
			return;
	
		int arrayLenHalf = array.length / 2;

		for ( int i = 0; i < arrayLenHalf; i++ )
		{
			double swap = array[ i ];
			array[i] = array[ array.length - i - 1 ];
			array[array.length - i - 1] = swap;
		}
	}

}
