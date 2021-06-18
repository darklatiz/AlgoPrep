package mx.com.geekflu.algo.prep.data.core.ifc;

public interface Queueable<T> {

  /**
   * Inserts the specified element into the queue.
   * If the task is successful, offer() returns true, if not it returns false.
   * @param data to be inserted in Queue
   * @return true if successful otherwise false
   */
  boolean offer(T data);

  /**
   * Returns the head of the queue. Returns null if the queue is empty.
   */
  T peek();

  /**
   * Returns and removes the head of the queue. Returns null if the queue is empty.
   * @return null if empty
   */
  T poll();

  boolean isEmpty();


}
