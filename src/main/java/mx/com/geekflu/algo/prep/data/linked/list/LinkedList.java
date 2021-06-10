package mx.com.geekflu.algo.prep.data.linked.list;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.Node;
import mx.com.geekflu.algo.prep.data.core.ifc.AbstractList;
import mx.com.geekflu.algo.prep.data.core.ifc.Direction;

import java.util.Collection;
import java.util.Objects;

@Slf4j
public class LinkedList<T> implements AbstractList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public LinkedList(T data) {
    Node<T> newNode = new Node<>(data);
    this.head = newNode;
    this.tail = newNode;
    this.size = 0;
  }

  public LinkedList() {

  }

  /**
   * Zero based position
   * @param position
   * @return
   */
  @Override
  public Node<T> get(int position) {
    if (position < 0 || position > this.size - 1) {
      return null;
    } else if (position == 0) {
      return getFirst();
    } else if (position == this.size - 1) {
      return getLast();
    } else {
      Node<T> current = this.head;
      for (int i = 0; i <= position; i++) {
        current = current.getNext();
      }
      Node<T> prev = current.getPrev();
      Node<T> next = current.getNext();
      current.setNext(null);
      current.setPrev(null);
      prev.setNext(next);
      next.setPrev(prev);
      this.size--;
      return current;
    }
  }

  /**
   * Returns and remove the first element of the list
   *
   * @return first element
   */
  @Override
  public Node<T> getFirst() {
    if (!isEmpty()) {
      Node<T> next = this.head.getNext();
      this.head.setNext(null);

      if (Objects.nonNull(next)) {
        next.setPrev(null);
      }
      Node<T> ret = this.head;
      this.head = next;
      this.size--;
      return ret;
    }
    return null;
  }

  @Override
  public Node<T> getLast() {
    return null;
  }

  /**
   * Inserts the data @ the end of the list
   *
   * @param data
   * @return true if appended to the last of the list
   */
  @Override
  public boolean append(T data) {
    Node<T> newNode = new Node<>(data);
    Node<T> current = this.tail;
    this.tail.setNext(newNode);
    this.tail = newNode;
    this.tail.setPrev(current);
    this.size++;
    return true;
  }

  @Override
  public boolean appendFirst(T data) {
    Node<T> newNode = new Node<>(data);
    if (isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      Node<T> after = this.head;
      this.head = newNode;
      this.head.setNext(after);
      after.setPrev(this.head);
    }
    this.size++;
    return true;
  }

  /**
   * Position zero based
   * @param position
   * @param data
   * @return
   */
  @Override
  public boolean insert(int position, T data) {
    if (isEmpty()) {
      return appendFirst(data);
    } else if(position < 0 || position > this.size - 1) {
      return append(data);
    } else {
      Node<T> newNode = new Node<>(data);
      Node<T> current = moveTo(position);
      Node<T> prev = current.getPrev();

      prev.setNext(newNode);
      newNode.setPrev(prev);
      newNode.setNext(current);
      current.setPrev(newNode);
      this.size++;

      return true;
    }
  }

  private Node<T> moveTo(int position) {
    Node<T> current = this.head;
    for (int i = 0; i < position; i++) {
      current = current.getNext();
    }
    return current;
  }

  @Override
  public boolean remove(T data) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<T> elements) {
    return false;
  }

  @Override
  public boolean contains(T data) {
    return false;
  }

  @Override
  public boolean isEmpty() {
    return size <= 0;
  }

  @Override
  public void clear() {
    if (!isEmpty()) {
      this.head = null;
      this.tail = null;
      this.size = 0;
    }
  }

  @Override
  public void print(Direction direction) {
    Node<T> initialNode = null;
    StringBuilder stringBuilder = new StringBuilder();
    if (direction == Direction.HEAD2TAIL) {
      initialNode = this.head;
      stringBuilder.append("HEAD -> ");
    } else {
      stringBuilder.append("TAIL -> ");
      initialNode = this.tail;
    }
    while (Objects.nonNull(initialNode)) {
      stringBuilder.append(initialNode.getItem());
      stringBuilder.append(" -> ");
      if (direction == Direction.HEAD2TAIL) {
        initialNode = initialNode.getNext();
      } else {
        initialNode = initialNode.getPrev();
      }
    }
    if (direction == Direction.HEAD2TAIL) {
      stringBuilder.append("TAIL");
    } else {
      stringBuilder.append("HEAD");
    }
    log.info(stringBuilder.toString());
  }

  @Override
  public void print() {
    print(Direction.HEAD2TAIL);
  }

  @Override
  public int size() {
    return this.size;
  }

}