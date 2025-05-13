package Aufgaben_Karrer_Streams.Aufgabe8_Performance;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class Aufgabe_Karrer_StreamPerformance {

	public static void main(String[] args) {
		
		
		System.out.println("\n************ int[], einfache Operation ************************\n");
		int[] array = generateIntArrayJava8(1_000_000);
		
		//Aufgabe: Zählen der Einsen im obigen Feld.
		//Vergleichen Sie die Ausführungszeit bei direkter Iteration mit for-Schleife
		//versus Lösung per sequentiellem Stream und parallelem Stream
		
		Instant start = Instant.now();		
		long result = getResultIterativ(array);
		Instant stop = Instant.now();
		System.out.println("Zeit int[] iterativ: " + Duration.between(start, stop).toMillis());
		System.out.println(result);
		
		start = Instant.now();		
		result = getresultByStream(array);
		stop = Instant.now();
		System.out.println("Zeit int[] stream: " + Duration.between(start, stop).toMillis());
		System.out.println(result);
				
		
		start = Instant.now();		
		result = getResultByStreamParallel(array);
		stop = Instant.now();
		System.out.println("Zeit int[] stream parallel: " + Duration.between(start, stop).toMillis());
		System.out.println(result);		
		
	}

	
	
	
	private static long getResultIterativ(int[] array) {
		//todo
		return 0L;
	}
	
	private static long getresultByStream(int[] array) {
		 //todo
		 return 0L;
	}
	
	private static long getResultByStreamParallel(int[] array) {
		//todo
		return 0L;
	}	
	
	
	/*
     * Feld erzeugen mit zufälliger Mischung mit Ganzzahlen zwischen 0 und 9
     * (ca. jeder 10. Wert ist 1)
     */
	private static int[] generateIntArray(int dimension) {
		int[] array = new int[dimension];
		for (int i = 0; i < dimension; i++) {
			array[i] = 1+ (int) (Math.random()*10);
		}
		return array;
	}
	
	private static int[] generateIntArrayJava8(int dimension) {
		int[] array = new int[dimension];
		Arrays.setAll(array, i -> 1+ (int) (Math.random()*10));
		return array;
	}
	
}
