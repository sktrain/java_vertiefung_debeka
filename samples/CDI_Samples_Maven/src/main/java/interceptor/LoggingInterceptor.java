package interceptor;

import jakarta.interceptor.AroundConstruct;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class LoggingInterceptor {

	@AroundConstruct
	private void init(InvocationContext ic) throws Exception {
		System.out.println("Entering constructor");
		try {
			ic.proceed();
		} finally {
			System.out.println("Exiting constructor");
		}
	}

	@AroundInvoke
	public Object logMethod(InvocationContext ic) throws Exception  {
		System.out.println(ic.getTarget().toString() + " : " + ic.getMethod().getName());
		try {
			return ic.proceed();
		} finally {
			System.out.println(ic.getTarget().toString() + " : " + ic.getMethod().getName());
		}
	}

}
