package mx.com.geekflu.algo.prep.data.structures.stack;

import mx.com.geekflu.algo.prep.data.structures.LinkedList;
import mx.com.geekflu.algo.prep.data.structures.Listable;

public class StackLL<T> implements Stackable<T> {
	
	private Listable<T> linkedList = new LinkedList<>();
	
	public StackLL() {
		
	}

	public StackLL(Listable<T> linkedList) {
		super();
		this.linkedList = linkedList;
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
		return linkedList.size() > 0 ? linkedList.head().getData() : null;
	}

	@Override
	public void print() {
		
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

}
