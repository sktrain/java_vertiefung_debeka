package reflection;

import java.io.Serializable;

public class C implements Serializable {

	private static final long serialVersionUID = 1L;

	public int i;

	private String s;

	public C() {
		System.out.println("Constructor of C");
		this.i = 4711;
		this.s = "Hello";
	}

	public C(int i, String s) {
		System.out.println("Constructor of C (" + i + ", " + s + ")");
		this.i = i;
		this.s = s;
	}

	public void f() {
		System.out.println("f: " + this.i + " " + this.s);
	}

	public int g(int i, String s) {
		System.out.println("g: " + i + " " + s);
		this.i = i;
		this.s = s;
		return this.i;
	}
	
	@Override
	public String toString() {
		return super.toString() + " [" + this.i + ", " + this.s + "]";
	}
}
