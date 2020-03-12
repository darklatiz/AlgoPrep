package mx.com.geekflu.algo.prep.data.structures.stack;

import java.util.Arrays;

public class Stack<T> implements Stackable<T> {
	
	private int INITIAL_CAPACITY = 10;
	private int indexToInsert;
	private T[] data;
	
	public Stack() {
		data = (T[]) new Object[INITIAL_CAPACITY];
	}

	@Override
	public T pop() {
		if(isEmpty()) return null;
		return data[--indexToInsert];
	}

	/**
	 * Push an element into the stack
	 */
	@Override
	public void push(T val) {
		if(!isFull()) {
			if(indexToInsert == data.length - 1) {
				indexToInsert = 0;
			}
		}else {
			data = Arrays.copyOf(this.data, this.data.length + INITIAL_CAPACITY);
		}
		data[indexToInsert++] = val;
	}

	@Override
	public T peek() {
		return isEmpty() ? null : data[indexToInsert - 1];
	}

	@Override
	public void print() {
		StringBuilder sb = new StringBuilder();
		for(int i = indexToInsert - 1 ; i >= 0 ; i--) {
			sb.append(data[i]);
			sb.append(" -> ");
		}
		System.out.println(sb.toString());
	}

	@Override
	public boolean isEmpty() {
		return indexToInsert <= 0;
	}

	@Override
	public boolean isFull() {
		return indexToInsert == data.length - 1;
	}

	@Override
	public int size() {
		return indexToInsert;
	}
	
	
	
}
