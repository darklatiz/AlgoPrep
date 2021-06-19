package mx.com.geekflu.algo.prep.data.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode<T> {
  T data;
  TreeNode<T> left;
  TreeNode<T> right;

  public TreeNode(T data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

}