package mx.com.geekflu.graph.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTreeNode<T> {
  private BinaryTreeNode<T> left;
  private BinaryTreeNode<T> right;
  private T data;
  private int count;

  public BinaryTreeNode(T data) {
    this.data = data;
  }

}
