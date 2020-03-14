package mx.com.geekflu.algo.prep.data.structures.queue;

import javax.naming.OperationNotSupportedException;

public interface Queueable<T> {
	
	/**
	 * Returns and removes the head of the queue. Returns null if the queue is empty.
	 * @return
	 */
	T poll();
	
	/**
	 * Inserts the specified element into the queue. 
	 * If the task is successful, add() returns true, 
	 * if not it throws an exception.
	 * @param data
	 * @return true if data is enqueued
	 * @throws OperationNotSupportedException 
	 * @throws Exception if element was not queued
	 */
	boolean add(T data) throws OperationNotSupportedException;
	
	/**
	 * Returns the head of the queue. Returns null if the queue is empty.
	 * @return
	 */
	T peek();
	
	String print(String delimiter);
	
	int size();
	
}
