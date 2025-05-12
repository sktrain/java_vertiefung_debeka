package dynamicproxy;

public class MathServiceImpl implements MathService {
	
	@Override
	public int add(int a, int b) {
		return a+b;
	}
	
	@Override
	public int diff(int a, int b) {
		return a-b;
	}

}
