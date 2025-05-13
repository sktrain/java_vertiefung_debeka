package Aufgaben_Karrer_Streams.Aufgabe3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringVerarbeitung {

	public static void main(String[] args) {

          String testString = getString();
          
          //Entferne die Satzzeichen und gib nur die Wörter aus, die mit einem Großbuchstaben beginnen
          Pattern.compile("[^\\p{L}]")
          .splitAsStream(testString)
          //.peek(System.out::println)
          .filter(word -> Character.isUpperCase(word.charAt(0)))   
          .forEach(System.out::println);
          
          
          //Zähle die Gesamtanzahl der Zeichen in den Wörtern, die mit einem Großbuchstaben beginnen
          long anzahl = Pattern.compile("[^\\p{L}]")
          .splitAsStream(testString)
          .filter(word -> Character.isUpperCase(word.charAt(0)))
          .flatMapToInt(String::chars)
          .count();
          System.out.println("Anzahl Zeichen: " + anzahl);
          
          
          //Partitioniere die Wörter in 2 Gruppen: beginnt mit Großbuchstabe oder Kleinbuchstabe
          Map<Boolean, List<String>> map = Pattern.compile("[^\\p{L}]")
          .splitAsStream(testString)
          .collect(Collectors.partitioningBy(word -> Character.isUpperCase(word.charAt(0))));
          
          // Vorsicht: Ausgabe kann den Zeilenpuffer der Console in Eclipse sprengen!
          System.out.println("Partitioniert: " + map);
          
          
          //Speichere pro Partition nur den lexikografisch größten String
          Map<Boolean, Optional<String>> mapmax = Pattern.compile("[^\\p{L}]")
          .splitAsStream(testString)
          .collect(Collectors.partitioningBy(word -> Character.isUpperCase(word.charAt(0)),
        		                             Collectors.maxBy(Comparator.naturalOrder())));
          System.out.println("Partitioniert mit Max: " + mapmax);
          
          
          //Speichere je Wort die Häufigkeit des Auftretens
         Map<String, Long> wordcount = Pattern.compile("[^\\p{L}]")
                  .splitAsStream(testString)
                  .collect(Collectors.groupingBy(Function.identity(),
                		                             Collectors.counting()));
         System.out.println("Häufigkeit je Wort: " + wordcount);
          

	}

	private static String getString() {
		return "Wer reitet so spät durch Nacht und Wind?"
				+ "Es ist der Vater mit seinem Kind;"
				+ "Er hat den Knaben wohl in dem Arm,"
				+ "Er faβt ihn sicher,er hält ihn warm."
				;
	}

}