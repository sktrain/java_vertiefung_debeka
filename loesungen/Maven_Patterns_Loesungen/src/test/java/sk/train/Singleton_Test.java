package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.function.Executable;

import sk.train.singletonenum.SingleLocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;



class Singleton_Test {
	
	private SingleLocalDate single1;
	private SingleLocalDate single2;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		single1 = SingleLocalDate.S;
		single2 = SingleLocalDate.S;
		
	}

	@Test
	void testSingleLocalDate() {
		assertSame(single1, single2);
	}
	
	@Test
	void testgetDate() {
		assertEquals(LocalDate.of(2000, 1, 1), single1.getL());
	}
	
	@Test
	void TestNotImmutable() {
		single2.setL(LocalDate.of(1900, 1, 1));
		assertEquals(LocalDate.of(1900, 1, 1), single1.getL());
	}
	
		
	//but with serialization
	@Test
	void serializeTest() {
		SingleLocalDate scopy = null;
		try (
				 ByteArrayOutputStream bos = new ByteArrayOutputStream();
						ObjectOutputStream oos = new ObjectOutputStream(bos)) {
					oos.writeObject(single1);			
					ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
					ObjectInputStream ois = new ObjectInputStream(bis);
					scopy  = (SingleLocalDate) ois.readObject();
			} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
		}
		assertSame(scopy, single2);  //serialization returns copy
	}
	
	//but with reflection
	@Test
	void reflectionTest() {
		    Executable ex = () -> {
		    	Object o = null;
		    	Class<? extends SingleLocalDate> clazz = single1.getClass();
		    	Constructor<? extends SingleLocalDate> con = null;
//		    	for (Constructor c : clazz.getDeclaredConstructors()) {
//						System.out.println(c);
//					}
				con = clazz.getDeclaredConstructor(String.class, int.class, LocalDate.class);
				con.setAccessible(true);
		    	o = con.newInstance("S", 0, LocalDate.of(1900, 1, 1));
		    };
			Exception e = assertThrows(Exception.class, ex);
			System.err.println(e);
		}


}
