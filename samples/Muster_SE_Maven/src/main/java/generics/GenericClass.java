package generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericClass {

	public static void main(String[] args) {
		
		// Nutzung einer rohen Liste
		List al = new ArrayList();

		al.add("Hallo");
		al.add(new Date());

		String t = (String) al.get(0);
		System.out.println(t);
		
		//Nutzung einer typisierten Liste

		List<String> als = new ArrayList<>();
		als.add(new Date().toString());
		//jetzt nur noch Strings m�glich
		//als.add(new Date()); 
		t = als.get(0);
		System.out.println(t);
		
		//Mischen von roh und typisiert: Typ-Sicherheit ist zum Teufel
		al = als;
		al.add(1);
		  
		  
		//Nutzung eigener generischer Klasse 	  
		  
		MyWrapper mr = new MyWrapper();
		mr.setE("Hallo");

		MyWrapper<Integer> mi = new MyWrapper<>();
		mi.setE(1);
		int b = mi.getE();
		
		//Nutzung einer eingeschränkten generischen Klasse
		MyWrapperNumber mn = new MyWrapperNumber();
		//jetzt ist mindestens Number nötig, das sieht die VM
		//mn.setE("Hallo"); 
	}

}

class MyWrapper<E>{
	private E e;

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}	
}

class MyWrapperNumber<E extends Number>{
	private E e;

	public int getE() {
		return e.intValue();
	}

	public void setE(E e) {
		this.e = e;
	}	
}
