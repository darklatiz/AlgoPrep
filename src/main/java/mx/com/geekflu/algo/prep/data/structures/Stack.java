package mx.com.geekflu.algo.prep.data.structures;

public class Stack<T> implements Stackable<T> {
	
	private int INITIAL_CAPACITY = 20;
	private int top;
	private T[] data;
	private int count;
	
	public Stack() {
		data = (T[]) new Object[INITIAL_CAPACITY];
	}

	
	public void print() {
		for(int i = 0; i < data.length ; i++) {
			System.out.print(data[i].toString());
			System.out.print(" -> ");
		}
	}

	@Override
	public T pop() {
		
		return null;
	}


	@Override
	public void push(T val) {
		
	}


	@Override
	public T peek() {
		return null;
	}


	@Override
	public boolean isEmpty() {
		return count <= 0;
	}

}
