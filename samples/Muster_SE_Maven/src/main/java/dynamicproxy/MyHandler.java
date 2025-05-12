package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
	
	private Object target;	

	public MyHandler(Object target) {
		super();
		this.target = target;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.err.println("Hier ist der Handler mit Methode: " + method);
		if (target instanceof InvocationHandler)  //Ziel ist nächster Handler in einer Handler-Chain
			return ((InvocationHandler) target).invoke(proxy, method, args);
		else //Zielbohne
			return method.invoke(target, args);
	}

}
