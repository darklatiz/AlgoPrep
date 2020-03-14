package mx.com.geekflu.algo.prep.data.structures.queue;

import javax.naming.OperationNotSupportedException;

public class Queue<T> implements Queueable<T> {

	private T[] data;
	private int top;
	private int tail;
	private int size;

	public Queue() {
		this.data = (T[]) new Object[10];
		this.top = 0;
		this.tail = 0;
	}

	public Queue(int capacity) {
		this.data = (T[]) new Object[capacity];
		this.top = 0;
		this.tail = 0;
	}

	@Override
	public T poll() {
		if (this.top != this.tail) {
			T val = this.data[top++];
			this.size--;
			return val;
		} else {
			return null;
		}
	}

	@Override
	public boolean add(T value) throws OperationNotSupportedException {
		if(this.size == data.length && 
				this.tail == data.length) {
			throw new OperationNotSupportedException("Queue full! Keep Trying");
		}else if(this.tail == data.length) {
			this.tail = 0;
		}
		this.data[tail++] = value;
		this.size++;
		return true;
	}

	@Override
	public T peek() {
		T val = this.data[top];
		return val;
	}

	public static void main(String[] args) {
		Queueable<String> q = new Queue<>();
		try {
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
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}

		System.out.println("Removing an element from queue: " + q.poll());
		System.out.println("Size: " + q.size());

		System.out.println("Removing an element from queue: " + q.poll());
		System.out.println("Size: " + q.size());

		System.out.println("Removing an element from queue: " + q.poll());
		System.out.println("Size: " + q.size());

		System.out.println("Removing an element from queue: " + q.poll());
		System.out.println("Size: " + q.size());

		System.out.println("Removing an element from queue: " + q.poll());
		System.out.println("Size: " + q.size());

		System.out.println("Removing an element from queue: " + q.poll());
		System.out.println("Size: " + q.size());

		System.out.println("Removing an element from queue: " + q.poll());
		System.out.println("Size: " + q.size());

		System.out.println("Removing an element from queue: " + q.poll());
		System.out.println("Size: " + q.size());

		System.out.println("Removing an element from queue: " + q.poll());
		System.out.println("Size: " + q.size());

		System.out.println("Removing an element from queue: " + q.poll());
		System.out.println("Size: " + q.size());

		System.out.println("Removing an element from queue: " + q.poll());
		System.out.println("Size: " + q.size());

		try {
			q.add("es5");
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(q.print("->"));
	}

	@Override
	public String print(String delimiter) {
		StringBuilder st = new StringBuilder();

		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

}
