package procedural;

public class QuadratGleichung {

	public static void main(String[] args) {

		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double c = Double.parseDouble(args[2]);
		
        System.out.println( "" + a +":" + b + ":" + c);
        
        if ( a == 0.0) { // b * x + c = 0  => x = -c / b
        	
        	if (b == 0.0) {
        		if ( c == 0.0) {
        			System.out.println("Alle x sind Lösungen");
        		} else {
        			System.out.println("Kein x erfüllt die Gleichung");
        		}
        	} else {
        		System.out.println("x ist: " + (-c / b));
        	}
        	
        } else {
        	if ((b * b - 4 * a * c) < 0.0) {
        		System.out.println("Kein x erfüllt die Gleichung");
        	} else {
        		double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        		double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        		
        		System.out.println("Hier kommt der erste Wert: " + x1);
        		System.out.println("Hier kommt der zweite Wert: " + x2);
        	}
        }
		
	}

}
