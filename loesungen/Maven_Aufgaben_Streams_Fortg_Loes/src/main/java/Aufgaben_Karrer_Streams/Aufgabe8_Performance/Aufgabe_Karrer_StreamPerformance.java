package Aufgaben_Karrer_Streams.Aufgabe8_Performance;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class Aufgabe_Karrer_StreamPerformance {

	public static void main(String[] args) {
		
		System.out.println("\n************ int[], einfache Operation ************************\n");
		int[] array = generateIntArray(1_000_000);
		
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
		
		System.out.println("\n************ ArrayList<Integer>, einfache Operation ************************\n");
		ArrayList<Integer> al = generateArrayList(1_000_000);
		
		start = Instant.now();
		result = getResultIterativ(al);
		stop = Instant.now();
		System.out.println("Zeit ArrayList<Integer> iterativ: " + Duration.between(start, stop).toMillis());
		System.out.println(result);
		
		start = Instant.now();
		result = getResultByIterator(al);
		stop = Instant.now();
		System.out.println("Zeit ArrayList<Integer> Iterator: " + Duration.between(start, stop).toMillis());
		System.out.println(result);
		
		start = Instant.now();
		result = getresultByStream(al);
		stop = Instant.now();
		System.out.println("Zeit ArrayList<Integer> stream: " + Duration.between(start, stop).toMillis());
		System.out.println(result);
		
		start = Instant.now();
		result = getResultByStreamParallel(al);
		stop = Instant.now();
		System.out.println("Zeit ArrayList<Integer> stream parallel: " + Duration.between(start, stop).toMillis());
		System.out.println(result);	
		
		System.out.println("\n************ int[], Fakultaet ************************\n");
		start = Instant.now();
		result = getResultIterativFak(array);
		stop = Instant.now();
		System.out.println("Zeit int[] iterativ mit Fakultaet: " + Duration.between(start, stop).toMillis());
		System.out.println(result);	
		
		start = Instant.now();
		result = getresultByStreamFak(array);
		stop = Instant.now();
		System.out.println("Zeit int[] stream mit Fakultaet: " + Duration.between(start, stop).toMillis());
		System.out.println(result);	
		
		start = Instant.now();
		result = getResultByStreamParallelFak(array);
		stop = Instant.now();
		System.out.println("Zeit int[] stream parallel mit Fakultaet: " + Duration.between(start, stop).toMillis());
		System.out.println(result);	
		
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
	
	/*
     * ArrayList erzeugen mit zufälliger Mischung mit Ganzzahlen zwischen 1 und 10
     * (ca. jeder 10. Wert ist 1)
     */
	private static ArrayList<Integer> generateArrayList(int dimension) {
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < dimension; i++) {
			al.add(1 +(int) (Math.random()*10));
		}
		return al;
	}
	
	private static long getResultIterativ(int[] array) {
		//da count bei Streams mit long arbeitet
		long result = 0;
		for(int i = 0; i < array.length; i++)
        {
            if(array[i] == 1) { result ++; }
        }
		return result;
	}
	
	private static long getresultByStream(int[] array) {
		 return Arrays.stream(array).filter( i -> i==1).count();
	}
	
	private static long getResultByStreamParallel(int[] array) {
		return Arrays.stream(array).parallel().filter( i -> i==1).count();
	}
	
	private static long getResultIterativ(ArrayList<Integer> list) {
		long result = 0;
		for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) == 1) { result ++; }
        }
		return result;
	}
	
	private static long getResultByIterator(ArrayList<Integer> list) {
		long result = 0;
		for(int i : list)
        {
            if(i == 1) { result ++; }
        }
		return result;
	}
	
	private static long getresultByStream(ArrayList<Integer> list) {
		 return list.stream().filter( i -> i==1).count();
	}
	
	private static long getResultByStreamParallel(ArrayList<Integer> list) {
		return list.stream().parallel().filter( i -> i==1).count();
	}
	
	private static int fakultaet(int n) {
		int result = 1;
		for(int i = 2; i <=n; ++i) { result = result * i; }
		return result;		
	}
	
	private static int getResultIterativFak(int[] array) {
		int result = 0;
		for(int i = 0; i < array.length; i++)
        {
            result = result + fakultaet(array[i]);
        }
		return result;
	}
	
	private static long getresultByStreamFak(int[] array) {
		 return Arrays.stream(array).map(i -> fakultaet(i)).sum();
	}
	
	private static long getResultByStreamParallelFak(int[] array) {
		return Arrays.stream(array).parallel().map(i -> fakultaet(i)).sum();
	}
	
	
}
