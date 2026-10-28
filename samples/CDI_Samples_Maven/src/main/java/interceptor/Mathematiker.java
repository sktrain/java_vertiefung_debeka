package interceptor;

import jakarta.interceptor.Interceptors;

@Interceptors(LoggingInterceptor.class)
public class Mathematiker {
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public int diff(int a, int b) {
		return a-b;
	}

}
