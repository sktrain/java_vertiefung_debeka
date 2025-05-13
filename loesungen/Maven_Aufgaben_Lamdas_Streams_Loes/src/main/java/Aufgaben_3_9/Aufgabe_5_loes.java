package Aufgaben_3_9;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Aufgabe_5_loes {
	
	public static void main(String[] args) {
		
		IntStream ints = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		OptionalInt max = ints.max();
		max.ifPresent(System.out::println);
		
		ints = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		OptionalInt min = ints.min();
		min.ifPresent(System.out::println);
		
		ints = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int sum = ints.sum();
		System.out.println(sum);
		
		ints = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		OptionalDouble avg = ints.average();
		avg.ifPresent(System.out::println);
		
		ints = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		IntSummaryStatistics stat = ints.summaryStatistics();
		System.out.println(stat);
		
	}

}
