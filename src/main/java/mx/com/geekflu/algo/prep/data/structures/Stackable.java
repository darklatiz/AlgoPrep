package mx.com.geekflu.algo.prep.data.structures;

public interface Stackable<T> {
	T pop();
	void push(T val);
	T peek();
	
	/**
	 * Prints the content of the stack following the next format
	 * <b>A | B | C | D</b>
	 */
	void print();
	
	/**
	 * Checks if the stack is empty
	 * @return true is Stack is empty
	 */
	boolean isEmpty();
	
	/**
	 * Checks if Stack is full
	 * @return true is stack is full
	 */
	boolean isFull();
	
	int size();
}
