package oo;


class MyOuter {
	private String outer = "Outer";
	public String getName(){
		MyInner mi = new MyInner();
		return mi.getName();	}
	private class MyInner {
		private String inner = "Inner";
		private String getName(){
			return outer +":"+ inner;	}	
	}	}

class Caller{
	public static void main(String[] args){
		MyOuter mo = new MyOuter();
		System.out.println(mo.getName());
	}
	
}