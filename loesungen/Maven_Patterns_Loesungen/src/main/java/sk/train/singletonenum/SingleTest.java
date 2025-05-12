package sk.train.singletonenum;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class SingleTest {
	
	public static void main(String[] args) {
		
		SingleLocalDate single1 = SingleLocalDate.S;
		SingleLocalDate single2 = SingleLocalDate.S;
		System.out.println(single1==single2);
		
		LocalDate l = single1.getL(); System.out.println(l);
		single1.setL(l.minusYears(1));
		System.out.println(single2.getL());
		
		//but with serialization
		try (
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(single1);			
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			single2 = (SingleLocalDate) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		System.out.println(single1 == single2);  //true, serialization returns original
		
		//but with reflection
		single2 = single1;
		Class<? extends SingleLocalDate> clazz = single1.getClass();
		Constructor<? extends SingleLocalDate> con = null;
		try {
				for (Constructor c : clazz.getDeclaredConstructors()) {
					System.out.println(c);
				}
				con = clazz.getDeclaredConstructor(String.class, int.class, LocalDate.class);
				con.setAccessible(true);
//				System.out.println(con);
			} catch (NoSuchMethodException | SecurityException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		try {
			    //System.out.println(single1.ordinal());
				single2 = (SingleLocalDate) con.newInstance("S", 0, LocalDate.of(1900, 1, 1));
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println(single1 == single2);  //reflection results in exception
	}


}
