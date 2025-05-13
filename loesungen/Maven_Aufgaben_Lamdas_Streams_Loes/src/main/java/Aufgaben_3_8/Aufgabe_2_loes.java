package Aufgaben_3_8;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Aufgabe_2_loes {

	public static void main(String[] args) {
		
		Predicate<Integer> isEven = (Integer i) -> { return (i%2 == 0);};
		System.out.println(isEven.test(2));
		
		Predicate<Integer> isNull = i -> i.equals(0);
		System.out.println(isNull.test(0));
		
		IntPredicate isPositive = i -> i>0;
		System.out.println(isPositive.test(-1));
		
		IntPredicate isEvenint = i -> i%2==0;
		IntPredicate isNullint = i -> i == 0;
				
		IntPredicate combined = isEvenint.and(isPositive);
		System.out.println(combined.test(3));
		System.out.println(combined.test(4));
		
		IntPredicate combined2 = isEvenint.negate().and(isPositive);
		System.out.println(combined2.test(3));
		System.out.println(combined2.test(4));
			
		
		Predicate<String> isShortWord = s -> s.length() < 4;
		System.out.println(isShortWord.test("Hallo"));
		System.out.println(isShortWord.test("hu"));
		

	}

}
