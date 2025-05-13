package Aufgaben_Karrer_Streams.Aufgabe3;

public class StringVerarbeitung {

	public static void main(String[] args) {

          String testString = getString();
          
          //Entferne die Satzzeichen und gib nur die Wörter aus, die mit einem Großbuchstaben beginnen.
          //Die Klasse Pattern kann ab Java 8 die Treffer als Stream liefern.
          //Verwenden Sie "Pattern.compile("[^\\p{L}]")"
         
          
          //Z�hle die Gesamtanzahl der Zeichen in den Wörtern, die mit einem Großbuchstaben beginnen
          
          
          
          //Partitioniere die Wörter in 2 Gruppen: beginnt mit Großbuchstabe oder Kleinbuchstabe
          
          
          
          
          
          //Speichere pro Partition nur den lexikografisch größten String
          
          
          
          //Speichere je Wort die Häufigkeit des Auftretens
         
          

	}

	private static String getString() {
		return "Wer reitet so sp�t durch Nacht und Wind?"
				+ "Es ist der Vater mit seinem Kind;"
				+ "Er hat den Knaben wohl in dem Arm,"
				+ "Er fa�t ihn sicher,er h�lt ihn warm."
				;
	}

}