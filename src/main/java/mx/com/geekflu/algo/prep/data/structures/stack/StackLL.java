package mx.com.geekflu.algo.prep.data.structures.stack;

import mx.com.geekflu.algo.prep.data.structures.Node;

public class StackLL<T> implements Stackable<T> {
	
	private Node<T> head;
	private int size = 0;
	
	public StackLL() {
		
	}

	@Override
	public T pop() {
		if(isEmpty()) return null;
		else {
			Node<T> temp = head;
			head = temp.getNext();
			size--;
			return temp.getData();
		}
	}

	@Override
	public void push(T val) {
		Node<T> newNode = new Node<>(val);
		if(isEmpty()) {
			head = newNode;
		}else {
			Node<T> temp = head;
			newNode.setNext(temp);
			head = newNode;
		}
		size++;
	}

	@Override
	public T peek() {
		return !isEmpty() ? head.getData() : null;
	}

	@Override
	public String print(String delimiter) {
		Node<T> temp = this.head;
		StringBuilder st = new StringBuilder();
		while (temp != null) {
			st.append(" ");
			st.append(temp.getData());
			st.append(" ");
			
			if(temp.getNext() != null)
				st.append(delimiter);
			
			temp = temp.getNext();
		}
		return st.toString();
	}

	@Override
	public boolean isEmpty() {
		return this.size <= 0;
	}

	@Override
	public boolean isFull() {
		throw new UnsupportedOperationException("");
	}

	@Override
	public int size() {
		return this.size;
	}
	
	public static void main(String[] args) {
		StackLL<String> stack = new StackLL<>();
		stack.push("hola");
		stack.push("####");
		stack.push("mundo");
		stack.push("the");
		stack.push("best");
		stack.push("to");
		stack.push("develop in java!");
		System.out.println("Peeking: " + stack.peek());
		System.out.println("Poping: " + stack.pop());
		System.out.println("Elements in stack: " + stack.print("<-"));
		
		//poping all the data
		String dato = null;
		while((dato = stack.pop()) != null) {
			System.out.print(dato);
			System.out.print(" <- ");
		}
		System.out.println("");
		System.out.println("Stack Size: " + stack.size());
		System.out.println("Stack peek: " + stack.peek());
	}

}
