package mx.com.geekflu.algo.prep.data.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {
  private T item;
  private Node<T> next;
  private Node<T> prev;
  //this property will have and old value, min / max
  private Node<T> oldValue;

  public Node(T data){
    this.item = data;
  }



}
