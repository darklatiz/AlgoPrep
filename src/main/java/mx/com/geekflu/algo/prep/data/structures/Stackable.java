package mx.com.geekflu.algo.prep.data.structures;

public interface Stackable<T> {
	T pop();
	void push(T val);
	T peek();
	void print();
	
	/**
	 * Checks if the stack is empty
	 * @return true is Stack is empty
	 */
	boolean isEmpty();
}
