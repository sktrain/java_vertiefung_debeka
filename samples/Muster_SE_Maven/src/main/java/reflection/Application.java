package reflection;

import java.lang.reflect.*;

public class Application {
	public static void main(String[] args) {
		
		//nur  Analyse anhand der Klasse
		test1();
		test2();
		test3();
		test4();
		
		//Erzeugung eines Objekts der Klasse + Zugriff auf private Member
		test5();
		test6();
		
	}
	
	private static void test1() {
		System.out.println();
		try {
			Class<?> cls = Class.forName("reflection.C");
			Field field = cls.getField("i");
			Class<?> type = field.getType();
			System.out.print(type.getSimpleName());
			System.out.println(" " + field.getName());
		}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		catch (NoSuchFieldException e) {
			System.out.println(e);
		}
	}

	private static void test2() {
		System.out.println();
		try {
			Class<?> cls = Class.forName("reflection.C");
			Method method = cls.getMethod("f");
			Class<?> returnType = method.getReturnType();
			System.out.print(returnType.getSimpleName() + " ");
			System.out.print(method.getName() + "(");
			Class<?>[] parameterTypes = method.getParameterTypes();
			for (int i = 0; i < parameterTypes.length; i++) {
				if (i > 0)
					System.out.print(", ");
				Class<?> parameterType = parameterTypes[i];
				System.out.print(parameterType.getSimpleName());
			}
			System.out.println(")");
		}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		catch (NoSuchMethodException e) {
			System.out.println(e);
		}
	}

	private static void test3() {
		System.out.println();
		try {
			Class<?> cls = Class.forName("reflection.C");
			Method method = cls.getMethod("g", int.class, String.class);
			Class<?> returnType = method.getReturnType();
			System.out.print(returnType.getSimpleName() + " ");
			System.out.print(method.getName() + "(");
			Class<?>[] parameterTypes = method.getParameterTypes();
			for (int i = 0; i < parameterTypes.length; i++) {
				if (i > 0)
					System.out.print(", ");
				Class<?> parameterType = parameterTypes[i];
				System.out.print(parameterType.getSimpleName());
			}
			System.out.println(")");
		}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		catch (NoSuchMethodException e) {
			System.out.println(e);
		}
	}

	private static void test4() {
		System.out.println();
		try {
			Class<?> cls = Class.forName("reflection.C");
			Constructor<?> constructor = cls.getConstructor(int.class, String.class);
			System.out.print(constructor.getName() + "(");
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			for (int i = 0; i < parameterTypes.length; i++) {
				if (i > 0)
					System.out.print(", ");
				Class<?> parameterType = parameterTypes[i];
				System.out.print(parameterType.getSimpleName());
			}
			System.out.println(")");
		}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		catch (NoSuchMethodException e) {
			System.out.println(e);
		}
	}

	private static void test5() {
		System.out.println();
		try {
			Class<?> cls = Class.forName("reflection.C");
			Object obj = cls.getDeclaredConstructor().newInstance();
			Field fi = cls.getField("i");
			Object vi = fi.get(obj);
			System.out.println(vi);
			Field fs = cls.getDeclaredField("s");
			fs.setAccessible(true);
			Object vs = fs.get(obj);
			System.out.println(vs);
		}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		catch (InstantiationException e) {
			System.out.println(e);
		}
		catch (IllegalAccessException e) {
			System.out.println(e);
		}
		catch (NoSuchFieldException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test6() {
		System.out.println();
		try {
			Class<?> cls = Class.forName("reflection.C");
			Object obj = cls.getDeclaredConstructor().newInstance();
			Field fi = cls.getField("i");
			fi.set(obj, 5000);
			Field fs = cls.getDeclaredField("s");
			fs.setAccessible(true);
			fs.set(obj, "World");
			System.out.println(obj);
		}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		catch (InstantiationException e) {
			System.out.println(e);
		}
		catch (IllegalAccessException e) {
			System.out.println(e);
		}
		catch (NoSuchFieldException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}