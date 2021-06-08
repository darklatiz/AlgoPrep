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

  @Override
  public Node<T> get(int position) {
    return null;
  }

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

  @Override
  public boolean append(int position, T data) {
    if (isEmpty()) {
      return appendFirst(data);
    } else {
      Node<T> prevNode = get(position - 1);
      Node<T> newNode = new Node<>(data);
      Node<T> afterNode = prevNode.getNext();
      prevNode.setNext(newNode);
      newNode.setPrev(prevNode);
      newNode.setNext(afterNode);
      afterNode.setPrev(newNode);
      return true;
    }
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
  public boolean contains(T node) {
    return false;
  }

  @Override
  public boolean isEmpty() {
    return size <= 0;
  }

  @Override
  public void clear() {

  }

  @Override
  public void print(Direction direction) {
    Node<T> initialNode = null;
    if (direction == Direction.HEAD2TAIL) {
      initialNode = this.head;
    } else {
      initialNode = this.tail;
    }
    log.info("Using printing direction {}", direction);
    while (Objects.nonNull(initialNode)) {
      log.info("{}", initialNode.getItem());
      if (direction == Direction.HEAD2TAIL) {
        initialNode = initialNode.getNext();
      }else {
        initialNode = initialNode.getPrev();
      }
    }
  }

  public static void main(String[] args) {
    LinkedList<String> myStringLinkedList = new LinkedList<>();
    myStringLinkedList.appendFirst("h");
    myStringLinkedList.appendFirst("0");
    myStringLinkedList.appendFirst("l");
    myStringLinkedList.appendFirst("a");
    myStringLinkedList.print(Direction.HEAD2TAIL);
    myStringLinkedList.print(Direction.TAIL2HEAD);
  }
}