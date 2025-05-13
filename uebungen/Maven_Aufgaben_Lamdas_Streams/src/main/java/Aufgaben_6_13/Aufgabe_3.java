package Aufgaben_6_13;

public class Aufgabe_3 {

	public static void main(final String[] args) {
		final int[] original = new int[200];
		specialFill(original);
		printRange(original, 0, 20);
		printRange(original, 100, 120);
		printRange(original, 180, 200);
	}

	private static void specialFill(final int[] values) {
		for (int j = 0; j < values.length / 100; j++) {
			for (int i = 0; i < 100; i++) {
				values[j * 100 + i] = i;
			}
		}
	}

	private static void printRange(final int[] values, final int startIdx, final int endIdx) {
		for (int i = startIdx; i < endIdx; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
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
