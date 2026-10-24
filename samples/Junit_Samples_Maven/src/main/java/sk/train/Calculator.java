package sk.train;

public class Calculator {
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public int mult(int a, int b) {
		return a*b;
	}
	
	//mit Overflow
	public int fakultaet(int n) {
		int result = 1;
		for (int i=2; i <=n; ++i ) {
			result = result * i;
		}
		return result;
	}
	
	//mit Exception bei Overflow
	public int fakultaetExact(int n) {
		int result = 1;
		for (int i=2; i <=n; ++i ) {
			result = Math.multiplyExact(result, i);
		}
		return result;
	}

}
