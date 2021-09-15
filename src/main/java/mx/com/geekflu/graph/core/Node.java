package mx.com.geekflu.graph.core;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node<T> {
  private T data;
  private Node<T> parent;
  private int rank;
}
