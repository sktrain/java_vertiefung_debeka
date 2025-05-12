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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sk.train.singleton.SingleLocalDate;

class Singleton_Test {
	
	private SingleLocalDate single1;
	private SingleLocalDate single2;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		single1 = SingleLocalDate.getInstance();
		single2 = SingleLocalDate.getInstance();
		
	}

	@Test
	void testSingleLocalDate() {
		assertSame(single1, single2);
	}
	
	@Test
	void testgetDate() {
		assertEquals(LocalDate.of(2000, 1, 1), single1.getDate());
	}
	
	@Test
	void TestNotImmutable() {
		single2.setDate(LocalDate.of(1900, 1, 1));
		assertEquals(LocalDate.of(1900, 1, 1), single1.getDate());
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
		assertNotSame(scopy, single2);  //serialization returns copy
	}
	
	//but with reflection
		@Test
		void reflectionTest() {
			SingleLocalDate scopy = null;
			Class<? extends SingleLocalDate> clazz = single1.getClass();
			try {
				Constructor<? extends SingleLocalDate> con = clazz.getDeclaredConstructor(LocalDate.class);
				con.setAccessible(true);
				scopy = (SingleLocalDate) con.newInstance(LocalDate.of(1900, 1, 1));
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			assertNotSame(scopy, single2);  //serialization returns copy
		}


}
