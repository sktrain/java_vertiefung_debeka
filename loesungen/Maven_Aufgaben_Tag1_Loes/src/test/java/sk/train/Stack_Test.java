package sk.train;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.train_memory.EmptyStackException;
import sk.train_memory.Stack;

class Stack_Test {
	
	private Stack s;

	@BeforeEach
	void setUp() throws Exception {
		s = new Stack();
	}

	@Test
	void testStack() {
		assertThrows(EmptyStackException.class, () -> s.pop(), "exception-handling is not correct");
	}

	@Test
	void testPush() {
		assertDoesNotThrow(() -> {for (int i=1; i < 100; ++i) {s.push(new Object());}}, "capacity to small");
	}

	@Test()
	void testPop() {
		s.push("1"); s.push("2"); s.push("3");
		assertSame("3", s.pop(), "stack implementation failed");
	}

}
