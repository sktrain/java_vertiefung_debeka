package Aufgaben_6_13;

public class Aufgabe_4 {
	
	public static void main(final String[] args)
	{
	final int[] original = new int[100_000];
	for (int i=0; i < original.length ; i++)
	{
	original[i] = i + 1;
	}
	System.out.println("sum: " + sum(original));
	}
	private static long sum(final int[] values)
	{
	int sum = 0;
	for (int i=0; i < values.length; i++)
	{
	sum = sum + values[i];
	}
	return sum;
	}

}
