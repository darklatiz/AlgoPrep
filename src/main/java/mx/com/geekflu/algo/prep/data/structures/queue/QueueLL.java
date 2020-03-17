package mx.com.geekflu.algo.prep.data.structures.queue;

import javax.naming.OperationNotSupportedException;

import mx.com.geekflu.algo.prep.data.structures.Node;

/**
 * Class that implements a Queue using a Linked List
 * @author vn04q89
 *
 */
public class QueueLL<T> implements Queueable<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size;

	@Override
	public T poll() {
		Node<T> first = this.head;
		T val = first.getData();
		this.head = first.getNext();
		first = null;
		this.size--;
		return val;
	}

	@Override
	public boolean add(T data) throws OperationNotSupportedException {
		Node<T> n = new Node<>(data);
		if(this.head == null) {
			this.head = n;
			this.tail = n;
		}else {
			tail.setNext(n);
			tail = n;
		}
		this.size++;
		return true;
	}

	@Override
	public T peek() {
		return this.head != null ? this.head.getData() : null;
	}

	@Override
	public String print(String delimiter) {
		StringBuilder tb = new StringBuilder();
		Node<T> temp = this.head;
		while(temp != null) {
			tb.append(" ");
			tb.append(temp.getData());
			tb.append(" ");
			tb.append(delimiter);
			temp = temp.getNext();
		}
		return tb.toString();
	}

	@Override
	public int size() {
		return this.size;
	}
	
	
	public static void main(String[] args) {
		QueueLL<Float> floats = new QueueLL<>();
		try {
			floats.add(10.34f);
			floats.add(110.34f);
			floats.add(1110.34f);
			floats.add(11110.34f);
			floats.add(111110.34f);
			floats.add(1111110.34f);
			floats.add(11111110.34f);
			floats.add(111111110.34f);
			
			System.out.println("Queue Float numbers: " + floats.print("|"));
			System.out.println("Queue Size: " + floats.size());
			System.out.println("Queue Peek: " + floats.peek());
			
			
			System.out.println("Queue Poll: " + floats.poll());
			System.out.println("Queue Size: " + floats.size());
			
			System.out.println("Queue Poll: " + floats.poll());
			System.out.println("Queue Size: " + floats.size());
			
			System.out.println("Queue Poll: " + floats.poll());
			System.out.println("Queue Size: " + floats.size());
			
			System.out.println("Queue Poll: " + floats.poll());
			System.out.println("Queue Size: " + floats.size());
			
			System.out.println("Queue Poll: " + floats.poll());
			System.out.println("Queue Size: " + floats.size());
			
			System.out.println("Queue Float numbers: " + floats.print("|"));
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
