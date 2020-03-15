package mx.com.geekflu.algo.prep;

import static org.junit.Assert.assertEquals;

import javax.naming.OperationNotSupportedException;

import org.junit.Test;

import mx.com.geekflu.algo.prep.data.structures.queue.Queue;
import mx.com.geekflu.algo.prep.data.structures.queue.Queueable;

public class QueueTest {

	@Test
	public void testQueueAdd() throws OperationNotSupportedException {
		Queueable<String> q = new Queue<>();
		q.add("hola");
		q.add(" ");
		q.add("mundo");
		q.add(" ");
		q.add("es0");
		q.add("es1");
		q.add("es2");
		q.add("es3");
		q.add("es4");
		q.add("es5");
		assertEquals(10, q.size());
		System.out.println("PRINTING QUEUE: " + q.print("->"));
	}

	@Test(expected = OperationNotSupportedException.class)
	public void testAddException() throws OperationNotSupportedException {
		Queueable<String> q = new Queue<>();
		q.add("hola");
		q.add(" ");
		q.add("mundo");
		q.add(" ");
		q.add("es0");
		q.add("es1");
		q.add("es2");
		q.add("es3");
		q.add("es4");
		q.add("es5");
		q.add("es6");
		System.out.println("PRINTING QUEUE: " + q.print("->"));
	}

	@Test
	public void testQueueSize() throws OperationNotSupportedException {
		Queueable<String> q = new Queue<>();
		q.add("hola");
		q.add(" ");
		q.add("mundo");
		q.add(" ");
		q.add("es0");
		q.add("es1");
		q.add("es2");
		q.add("es3");
		q.add("es4");
		q.add("es5");
		assertEquals(10, q.size());
		
		System.out.println("Removing element: " + q.poll());
		assertEquals(9, q.size());
		
		System.out.println("Removing element: " + q.poll());
		assertEquals(8, q.size());
		
		System.out.println("Removing element: " + q.poll());
		assertEquals(7, q.size());
		
		System.out.println("Removing element: " + q.poll());
		System.out.println("Removing element: " + q.poll());
		assertEquals(5, q.size());
		
		System.out.println("Removing element: " + q.poll());
		assertEquals(4, q.size());
		
		System.out.println("PRINTING QUEUE: " + q.print("->"));
	}
	

}
