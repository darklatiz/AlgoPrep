package mx.com.geekflu.algo.prep.data.structures;

public interface Listable<T> {
	
	/**
	 * Inserts a new node at the end of the list
	 * @param data
	 */
	void insert(T data);
	
	/**
	 * The data will be removed using equals comparison
	 * @param data
	 * @return Data or null if not found
	 */
	boolean remove(T data);
	
	/**
	 * 
	 * @return size of the list
	 */
	int size();
	
	/**
	 * Prints the content of the list
	 */
	void print();
	
	/**
	 * Prints the list in reverse order
	 */
	void printReverse();
	
	/**
	 * 
	 * @return the head of the Linked list
	 */
	Node<T> head();
	
	
}
