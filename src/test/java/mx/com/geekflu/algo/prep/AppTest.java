package mx.com.geekflu.algo.prep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mx.com.geekflu.algo.prep.data.structures.LinkedList;
import mx.com.geekflu.algo.prep.data.structures.stack.Stack;
import mx.com.geekflu.algo.prep.data.structures.stack.StackLL;

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
		System.out.println(stack.print("<-"));
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
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void createLinkedList() {
		LinkedList<Integer> ll = new LinkedList<>();
		assertNotNull(ll);
	}

	@Test
	public void addDataToLinkedListAndCheckSize() {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.insert(10);
		ll.insert(10);
		ll.insert(10);
		ll.insert(10);
		assertEquals(4, ll.size());
		ll.remove(10);
		assertEquals(3, ll.size());
		ll.insert(1);
		assertEquals(4, ll.size());

		ll.remove(1);
		ll.remove(10);
		ll.remove(10);
		assertEquals(1, ll.size());
	}

	@Test
	public void tesStackImplementationUsingLinkedList() {
		StackLL<String> stack = new StackLL<>();
		stack.push("hola");
		stack.push("####");
		stack.push("mundo");
		stack.push("the");
		stack.push("best");
		assertEquals(5, stack.size());

		stack.push("to");
		stack.push("develop in java!");

		assertEquals(7, stack.size());

		System.out.println("Peeking: " + stack.peek());
		assertEquals("develop in java!", stack.peek());

		String dato = stack.pop();
		System.out.println("Poping: " + dato);
		assertEquals("develop in java!", dato);

		System.out.println("Elements in stack: " + stack.print("<-"));

		// poping all the data
		dato = null;
		while ((dato = stack.pop()) != null) {
			System.out.print(dato);
			System.out.print(" <- ");
		}
		System.out.println("");
		System.out.println("Stack Size: " + stack.size());
		System.out.println("Stack peek: " + stack.peek());
		assertEquals(0, stack.size());
		System.out.println(" ");
	}

}
