package sk.train.wrapper;

public class TestIntegerWrapper {

	public static void main(String[] args) {
		
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		System.out.println(i1 == i2);
		
		i1 = 4711;
		i2 = 4711;
		System.out.println(i1 == i2);
		
		i1 = 1;
		i2 = 1;
		System.out.println(i1 == i2);

	}

}
