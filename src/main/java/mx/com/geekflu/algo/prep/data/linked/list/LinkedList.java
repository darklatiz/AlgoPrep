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
   *
   * @param position
   * @return
   */
  @Override
  public T get(int position) {
    if (position < 0 || position > this.size - 1) {
      return null;
    } else if (position == 0) {
      return getFirst();
    } else if (position == this.size - 1) {
      return getLast();
    } else {
      Node<T> current = this.head;
      for (var i = 0; i <= position; i++) {
        current = current.getNext();
      }
      var prev = current.getPrev();
      var next = current.getNext();
      current.setNext(null);
      current.setPrev(null);
      prev.setNext(next);
      next.setPrev(prev);
      this.size--;
      return current.getItem();
    }
  }

  /**
   * Returns and remove the first element of the list
   *
   * @return first element
   */
  @Override
  public T getFirst() {
    if (!isEmpty()) {
      var next = this.head.getNext();
      this.head.setNext(null);

      if (Objects.nonNull(next)) {
        next.setPrev(null);
      }
      var ret = this.head;
      this.head = next;
      this.size--;
      return ret.getItem();
    }
    return null;
  }

  @Override
  public T getLast() {
    if (isEmpty()) {
      return null;
    }
    if (this.head == this.tail) {
      var ret = this.head.getItem();
      this.head = null;
      this.tail = null;
      this.size--;
      return ret;
    }else {
      var prev = this.tail.getPrev();
      var current = this.tail;
      current.setPrev(null);
      prev.setNext(null);
      this.size--;
      this.tail = prev;
      return current.getItem();
    }
  }

  /**
   * Inserts the data @ the end of the list
   *
   * @param data
   * @return true if appended to the last of the list
   */
  @Override
  public boolean append(T data) {
    if (isEmpty()) {
      return appendFirst(data);
    }
    var newNode = new Node<>(data);
    var current = this.tail;
    this.tail.setNext(newNode);
    this.tail = newNode;
    this.tail.setPrev(current);
    this.size++;
    return true;
  }

  @Override
  public boolean appendFirst(T data) {
    var newNode = new Node<>(data);
    if (isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      var after = this.head;
      this.head = newNode;
      this.head.setNext(after);
      after.setPrev(this.head);
    }
    this.size++;
    return true;
  }

  /**
   * Position zero based
   *
   * @param position
   * @param data
   * @return
   */
  @Override
  public boolean insert(int position, T data) {
    if (isEmpty()) {
      return appendFirst(data);
    } else if (position < 0 || position > this.size - 1) {
      return append(data);
    } else {
      var newNode = new Node<>(data);
      var current = moveTo(position);
      var prev = current.getPrev();

      prev.setNext(newNode);
      newNode.setPrev(prev);
      newNode.setNext(current);
      current.setPrev(newNode);
      this.size++;

      return true;
    }
  }

  @Override
  public Node<T> moveTo(int position) {
    var current = this.head;
    for (var i = 0; i < position; i++) {
      current = current.getNext();
    }
    return current;
  }

  /**
   * firs occurrence
   *
   * @param data
   * @return
   */
  @Override
  public Node<T> moveTo(T data) {
    var current = this.head;
    while (current != null && !current.getItem().equals(data)) {
      current = current.getNext();
    }
    return current;
  }

  @Override
  public boolean remove(T data) {
    if (Objects.isNull(data) || isEmpty()) {
      return false;
    }
    var node = moveTo(data);

    if (Objects.nonNull(node) && node == this.head) {
      var next = node.getNext();
      node.setNext(null);
      if (Objects.nonNull(next)) {
        next.setPrev(null);
      }
      this.head = next;
    }else if (Objects.nonNull(node) && node == this.tail) {
      var prev = node.getPrev();
      node.setPrev(null);
      prev.setNext(null);
      this.tail = prev;
    } else if(Objects.nonNull(node)) {
      var next = node.getNext();
      var prev = node.getPrev();
      node.setNext(null);
      node.setPrev(null);
      prev.setNext(next);
      next.setPrev(prev);
    } else {
      return false;
    }
    this.size--;
    return true;
  }

  @Override
  public boolean containsAll(Collection<T> elements) {
    if (Objects.isNull(elements) || elements.isEmpty()) {
      return false;
    }
    var elementsSize = elements.size();

    var count = elements.stream()
      .filter(this::contains)
      .count();

    return count == elementsSize;
  }

  @Override
  public boolean contains(T data) {
    if (Objects.isNull(data) || isEmpty()) {
      return false;
    }
    var walker = this.head;
    while (Objects.nonNull(walker)) {
      if (walker.getItem() == data) {
        return true;
      }
      walker = walker.getNext();
    }
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
    var stringBuilder = new StringBuilder();
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LinkedList<?> that = (LinkedList<?>) o;

    if (size != that.size) return false;
    if (!Objects.equals(head, that.head)) return false;
    return Objects.equals(tail, that.tail);
  }

  @Override
  public int hashCode() {
    int result = head != null ? head.hashCode() : 0;
    result = 31 * result + (tail != null ? tail.hashCode() : 0);
    result = 31 * result + size;
    return result;
  }
}