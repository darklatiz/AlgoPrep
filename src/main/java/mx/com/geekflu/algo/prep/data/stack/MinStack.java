package mx.com.geekflu.algo.prep.data.stack;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.Node;
import mx.com.geekflu.algo.prep.data.core.ifc.Minimal;
import mx.com.geekflu.algo.prep.data.core.ifc.Printable;
import mx.com.geekflu.algo.prep.data.core.ifc.Stackable;

import java.util.Comparator;
import java.util.Objects;

@SuppressWarnings("ALL")
@Slf4j
@Getter
public class MinStack<T> implements Stackable<T>, Minimal<T>, Printable {

  private Node<T> top;
  private int size;
  private Comparator<T> comparator;


  public MinStack(Comparator<T> comparator) {
    this.comparator = comparator;
    this.size = 0;
  }

  @Override
  public T getMin() {
    if (isEmpty())
      return null;
    return this.top.getTheValue().getItem();
  }

  @Override
  public T extractMin() {
    return getMin();
  }

  @Override
  public void print() {
    var stringBuilder = new StringBuilder();
    if (isEmpty()) {
      log.info("EMPTY");
    }
    stringBuilder.append("TOP -> ");
    var current = this.top;
    while (Objects.nonNull(current)) {
      stringBuilder.append(current.getItem());
      stringBuilder.append(" -> ");
      current = current.getNext();
    }
    log.info(stringBuilder.toString());
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      return null;
    }
    var valueToPop = this.top;
    this.top = this.top.getNext();
    this.size--;

    valueToPop.setNext(null);
    valueToPop.setPrev(null);

    return valueToPop.getItem();
  }

  @Override
  public void push(T data) {
    var newNode = new Node<>(data);
    if (isEmpty()) {
      this.top = newNode;
      this.top.setTheValue(this.top);
    } else {

      newNode.setNext(this.top);
      this.top.setPrev(newNode);

      if (this.comparator.compare(data, this.top.getTheValue().getItem()) < 0) {
        newNode.setTheValue(newNode);
      } else {
        newNode.setTheValue(this.top.getTheValue());
      }

      this.top = newNode;
    }
    this.size++;
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      return null;
    }
    return this.top.getItem();
  }

  @Override
  public void clear() {

  }

  @Override
  public boolean isEmpty() {
    return this.size <= 0;
  }

  @Override
  public int size() {
    return this.size;
  }
}
