package format;
/* Formatierung im C-Style ist leider nicht voll internationalisiert
 * Datum/Zeit wird nicht umgesetzt
 */

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;


public class FormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Date d = new Date(1888243566);
		double x = 12344556.67;
		System.out.printf("%tT%n", d);
		System.out.printf("%tD%n", d);
		System.out.printf("%f%n", x);
		System.out.printf("%f%n", x);
		System.out.println(Locale.getDefault());
		Locale l = Locale.US;
		//Locale.setDefault(l);
		System.out.printf(l,"%tT%n", d);
		System.out.printf(l,"%tD%n", d);
		System.out.printf(l,"%f%n", x);
		System.out.printf(l,"%f%n", x);
			
		System.out.println("*********************************************");
		System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(d));
		System.out.println(DateFormat.getDateInstance(DateFormat.LONG, Locale.US).format(d));
		
		NumberFormat frmt = DecimalFormat.getCurrencyInstance( Locale.UK );
		//frmt.setCurrency( Currency.getInstance( "EUR" ) );
		System.out.println( frmt.format( 12345.6789 ) );  // EUR12,345.68
	}

}
