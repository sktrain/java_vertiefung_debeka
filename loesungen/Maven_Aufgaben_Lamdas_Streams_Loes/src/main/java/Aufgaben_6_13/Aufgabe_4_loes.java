package Aufgaben_6_13;

import java.util.Arrays;

public class Aufgabe_4_loes {

	public static void main(final String[] args) {
		final int[] original = new int[100_000];
//		for (int i = 0; i < original.length; i++) {
//			original[i] = i + 1;
//		}
//		System.out.println("sum: " + sum(original));
		
		Arrays.parallelSetAll(original, index -> index+1);
		System.out.println("sum: " + sumNeu(original));
	}

	private static long sum(final int[] values) {
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum = sum + values[i];
		}
		return sum;
	}
	
	private static long sumNeu (int[] values) {
		Arrays.parallelPrefix(values, (result, next) -> result + next);
		return values[values.length-1];
		//ist das Ergebnis korrekt??
		
	}

}
