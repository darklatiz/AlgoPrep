package mx.com.geekflu.algo.prep.data.stack;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.ifc.Direction;
import mx.com.geekflu.algo.prep.data.core.ifc.Stackable;
import mx.com.geekflu.algo.prep.data.linked.list.LinkedList;

@Slf4j
public class Stack<T> implements Stackable<T> {

  private LinkedList<T> stackContainer;


  public Stack() {
    this.stackContainer = new LinkedList<>();
  }

  @Override
  public T pop() {
    if (isEmpty()){
      return null;
    }
    return this.stackContainer.getFirst();
  }

  @Override
  public void push(T data) {
    this.stackContainer.appendFirst(data);
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      return null;
    }
    return this.stackContainer.moveTo(0).getItem();
  }

  @Override
  public void clear() {
    this.stackContainer.clear();
  }

  @Override
  public boolean isEmpty() {
    return this.stackContainer.isEmpty();
  }

  @Override
  public int size() {
    return this.stackContainer.size();
  }

  @Override
  public void print() {
    this.stackContainer.print(Direction.HEAD2TAIL);
  }
}
