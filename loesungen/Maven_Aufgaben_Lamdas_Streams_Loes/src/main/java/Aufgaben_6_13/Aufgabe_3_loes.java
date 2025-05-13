package Aufgaben_6_13;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class Aufgabe_3_loes {

	public static void main(final String[] args) {
		final int[] original = new int[200];
		specialFillNeu(original);
		printRange(original, 0, 20);
		printRange(original, 100, 120);
		printRange(original, 180, 200);
		modifyNeu(original);
		printRange(original, 0, 20);
		printRange(original, 100, 120);
		printRange(original, 180, 200);
	}
	
	private static void specialFillNeu(int[] values) {
		Arrays.parallelSetAll(values, index -> index % 100);
	}

	private static void specialFill(final int[] values) {
		for (int j = 0; j < values.length / 100; j++) {
			for (int i = 0; i < 100; i++) {
				values[j * 100 + i] = i;
			}
		}
	}
	
	private static void printRangeNeu(final int[] values, final int startIdx, final int endIdx) {
		//Arrays.asList(values).
		Arrays.spliterator(values, startIdx, endIdx)
		       .forEachRemaining((int i) -> System.out.println(i));
		//alternativ
		Arrays.spliterator(values, startIdx, endIdx)
	       .forEachRemaining((IntConsumer)System.out::println);
	}

	private static void printRange(final int[] values, final int startIdx, final int endIdx) {
		for (int i = startIdx; i < endIdx; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
	}
	
	private static void modifyNeu(final int[] values) {
		Arrays.setAll(values, i -> i%2==0 ? -i : i*2);
	}
	
	private static void modify(final int[] values) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] % 2 == 0) {
				values[i] *= -1;
			} else {
				values[i] *= 2;
			}
		}
	}

}
