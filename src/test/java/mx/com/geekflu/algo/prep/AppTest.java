package mx.com.geekflu.algo.prep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mx.com.geekflu.algo.prep.data.structures.Stack;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
	public void stackPushAndPeek() {
		Stack<String> stack = new Stack<>();
		stack.push("hola");
		stack.push("mundo");
		stack.push("cruel");
		stack.push("cruel");
		stack.push("cruel01");
		stack.print();
		assertFalse(stack.isEmpty());
		assertNotNull(stack.peek());
		System.out.println("Peek: " + stack.peek());
	}
	
	@Test
	public void PushAndPopToEmptyStack() {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		stack.push(i++);
		stack.push(i++);
		stack.push(i++);
		stack.push(i++);
		stack.push(i++);
		stack.push(i++);
		stack.push(i++);
		stack.push(i++);
		stack.push(i++);
		stack.push(i++);
		stack.push(i++);
		stack.push(i++);
		stack.push(i++);
		stack.push(i++);
		System.out.println("peek: " + stack.peek());
		assertEquals(i, stack.size());
		while(!stack.isEmpty()) {
			System.out.print (stack.pop() + " ");
		}
		System.out.println();
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
	}
	
	
}
