package mx.com.geekflu.algo.prep.data.queue;

import mx.com.geekflu.algo.prep.data.core.ifc.Printable;
import mx.com.geekflu.algo.prep.data.core.ifc.Queueable;

public class Queue<T> implements Queueable<T>, Printable {

  @Override
  public void print() {

  }

  @Override
  public boolean add() {
    return false;
  }

  @Override
  public boolean offer(T data) {
    return false;
  }

  @Override
  public T element() {
    return null;
  }

  @Override
  public T peek() {
    return null;
  }

  @Override
  public T remove() {
    return null;
  }

  @Override
  public T poll() {
    return null;
  }


}
