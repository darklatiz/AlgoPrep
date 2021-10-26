package mx.com.geekflu.algo.prep.stack;

public class MinStackLL {
  private Node head;
  private int size;

  public MinStackLL() {

  }

  public void push(int val) {
    Node n = new Node();
    n.value = val;
    if (this.isEmpty()) {
      n.theValue = n;
    } else {
      var after = this.head;
      // point to the min value
      if (after.theValue.value > val) {
        n.theValue = n;
      } else {
        n.theValue = after.theValue;
      }
      //insert at the top
      n.next = after;
    }
    this.head = n;
    this.size++;
  }

  public void pop() {
    Node retValue = null;
    if (this.size > 0) {
      retValue = this.head;
      this.head = retValue.next;
      this.size--;
    }
  }

  public int top() {
    return this.head.value;
  }

  public int getMin() {
    return this.head.theValue.value;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size <= 0;
  }
}

class Node {
  int value;
  Node theValue;
  Node next;

  public Node() {

  }
}

