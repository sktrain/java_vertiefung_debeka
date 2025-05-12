package sk.train.singleton;

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

			SingleLocalDate single1 = SingleLocalDate.getInstance();
			SingleLocalDate single2 = SingleLocalDate.getInstance();
			
			System.out.println(single1 == single2);
			System.out.println(single1.getDate());
			
			single2.setDate(LocalDate.of(1900, 1, 1));
			System.out.println(single1 == single2);
			System.out.println(single1.getDate());
			
			SingleLocalDateEager seager1 = SingleLocalDateEager.getInstance();
			SingleLocalDateEager seager2 = SingleLocalDateEager.getInstance();
			
			System.out.println(seager1 == seager2);
			System.out.println(seager1.getDate());
			
			seager2.setDate(LocalDate.of(1900, 1, 1));
			System.out.println(seager1 == seager2);
			System.out.println(seager1.getDate());
			
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
			System.out.println(single1 == single2);  //false, serialization returns copy
			
			//but with reflection
			single2 = single1;
			Class<? extends SingleLocalDate> clazz = single1.getClass();
			try {
				Constructor<? extends SingleLocalDate> con = clazz.getDeclaredConstructor(LocalDate.class);
				con.setAccessible(true);
				single2 = (SingleLocalDate) con.newInstance(LocalDate.of(1900, 1, 1));
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			System.out.println(single1 == single2);  //false, reflection permits constructor-call

	}

}
