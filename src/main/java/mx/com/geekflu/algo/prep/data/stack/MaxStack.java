package mx.com.geekflu.algo.prep.data.stack;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.Node;
import mx.com.geekflu.algo.prep.data.core.ifc.Maximum;
import mx.com.geekflu.algo.prep.data.core.ifc.Printable;
import mx.com.geekflu.algo.prep.data.core.ifc.Stackable;

import java.util.Comparator;
import java.util.Objects;

@SuppressWarnings("ALL")
@Slf4j
public class MaxStack<T> implements Stackable<T>, Maximum<T>, Printable {

  private Node<T> top;
  private int size;
  private Comparator<T> comparator;

  public MaxStack(Comparator<T> comparator) {
    this.size = 0;
    this.comparator = comparator;
  }

  @Override
  public T getMax() {
    if (isEmpty()) {
      return null;
    }
    return this.top.getTheValue().getItem();
  }

  @Override
  public T extractMax() {
    return getMax();
  }

  @Override
  public void print() {
    if (!isEmpty()) {
      var limit = 0;
      var current = this.top;
      var stringBuilder = new StringBuilder();
      stringBuilder.append("TOP -> ");
      while (Objects.nonNull(current) && limit++ < 20) {
        stringBuilder.append(current.getItem().toString());
        stringBuilder.append(" -> ");
        current = current.getNext();
      }
      if (limit >= 20) {
        stringBuilder.append(" ... ");
      }else {
        stringBuilder.append(" BOTTOM ");
      }
      log.info(stringBuilder.toString());
    }
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      return null;
    }
    var current = this.top;
    var next = this.top.getNext();
    this.top = next;
    this.size--;
    return current.getItem();
  }

  @Override
  public void push(T data) {
    Node<T> current = new Node<>(data);
    if (Objects.isNull(this.top)){
      this.top = current;
      this.top.setTheValue(this.top);
    }else {
      current.setNext(this.top);
      this.top.setPrev(current);

      if (this.comparator.compare(data, this.top.getTheValue().getItem()) > 0) {
        current.setTheValue(current);
      }else {
        current.setTheValue(this.top.getTheValue());
      }
      this.top = current;
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
    if (!isEmpty()) {
      this.top = null;
      this.size = 0;
    }
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
