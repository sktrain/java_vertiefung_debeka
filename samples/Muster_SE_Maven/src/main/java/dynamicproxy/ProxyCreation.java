package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyCreation {

	public static void main(String[] args) {
		// Nutzung des Mechanismus
		MyHandler handler = new MyHandler(new MathServiceImpl());
		MathService proxy = generateProxy(MathService.class, handler);
		System.out.println(proxy.add(2, 2));
		System.out.println(proxy.diff(10, 5));
		System.out.println(proxy.getClass());

	}
	
	
	//dynamische Proxy-Generierung seit Java 1.3
	public static MathService generateProxy (Class service, InvocationHandler handler) {
		return (MathService) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[] {service}, handler);
	}

}
