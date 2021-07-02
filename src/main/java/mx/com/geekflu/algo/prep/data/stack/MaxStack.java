package mx.com.geekflu.algo.prep.data.stack;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.Node;
import mx.com.geekflu.algo.prep.data.core.ifc.Maximum;
import mx.com.geekflu.algo.prep.data.core.ifc.Printable;
import mx.com.geekflu.algo.prep.data.core.ifc.Stackable;

import java.util.Objects;

@SuppressWarnings("ALL")
@Slf4j
public class MaxStack<T extends Comparable> implements Stackable<T>, Maximum<T>, Printable {

  private Node<T> top;
  private int size;

  public MaxStack() {
    this.size = 0;
  }

  @Override
  public T getMax() {
    if (isEmpty()) {
      return null;
    }
    return this.top.getOldValue().getItem();
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
      this.top.setOldValue(this.top);
    }else {
      current.setNext(this.top);
      this.top.setPrev(current);

      if (data.compareTo(this.top.getOldValue().getItem()) > 0) {
        current.setOldValue(current);
      }else {
        current.setOldValue(this.top.getOldValue());
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
