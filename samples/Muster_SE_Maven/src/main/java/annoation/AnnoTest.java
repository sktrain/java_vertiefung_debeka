package annoation;

import java.lang.annotation.*;

public class AnnoTest {

	public static void main(String[] args) {
		A a = new A();
		Class<? extends A> c = a.getClass();
		System.out.println(c.isAnnotationPresent(Revision.class));
		Annotation[] afeld = c.getAnnotations();
		for (Annotation an : afeld){
			System.out.println(an.toString());
		}
	}
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Revision {
	int id();
	String notiz();
	String kommentar() default "Default-Kommentar";
	
}

@Revision(id = 1, notiz = "Annotation für Klasse")
class A{
	//@Revision(id = 3, notiz = "Annotation für Attribut")
	private int x;
	
	@Revision(id = 2, notiz = "Annotation für Methode")
	public String toString(){
		return("Instanz von Klasse A");
	}
}

