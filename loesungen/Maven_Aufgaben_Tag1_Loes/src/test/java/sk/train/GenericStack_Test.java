package sk.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.train.generictype.EmptyStackException;
import sk.train.generictype.IllegalStrategyException;
import sk.train.generictype.Stack;


public class GenericStack_Test {

	private Stack<Number> numberStack;
	
	@BeforeEach
	public void setUp() throws Exception {
		numberStack = new Stack<Number>();
	}
	
	@Test
	void testStack() {
		assertThrows(EmptyStackException.class, () -> numberStack.pop(), "exception-handling is not correct");
	}

	@Test
	void testPush() {
		assertDoesNotThrow(() -> {for (int i=1; i < 100; ++i) {numberStack.push(i);}}, "capacity to small");
	}

	@Test()
	void testPop() {
		numberStack.push(1); numberStack.push(2); numberStack.push(3);
		assertSame(3, numberStack.pop(), "stack implementation failed");
	}
	
	
	@Test
	public void testIsEmpty() {
		assertTrue(numberStack.isEmpty());
	}

	@Test
	public void testPushAll() {
		Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
		numberStack.pushAll(integers);
		Collection<Number> numbers = new ArrayList<Number>();
		numberStack.popAll(numbers);
		assertArrayEquals(new Number[] {9, 5, 1, 4, 1, 3}, numbers.toArray(new Number[6]), "wrong order");
	}

	@Test
	public void getCapacity() {
        assertEquals(16, numberStack.getCapacity(), "wrong capacity");		
		for (int i = 1; i<20; ++i) {
			numberStack.push(i);
		}
		assertEquals(32, numberStack.getCapacity(), "wrong capacity");	
	}
	
	@Test
	public void testStackIntUnaryOperator() {
		numberStack = new Stack<Number>(cap -> cap + 5);
		assertEquals(16, numberStack.getCapacity(), "wrong capacity");
		for (int i = 1; i<20; ++i) {
			numberStack.push(i);
		}
		assertEquals(21, numberStack.getCapacity(), "wrong capacity");
	}
	
	@Test
	public void testStackIntUnaryOperatorWithException() {
		assertThrows(IllegalStrategyException.class, () -> numberStack = new Stack<>(cap -> cap), "illegale Strategie: kein Zuwachs");
		
	}
	
}
