package mx.com.geekflu.algo.prep.data.binary.tree;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.TreeNode;

import java.util.Objects;

@Getter
@Setter
@Slf4j
public class BinaryTree<T> {

  private TreeNode<T> root;

  public BinaryTree(T data) {
    this.root = new TreeNode<>(data);
  }

  public BinaryTree() {
    this.root = null;
  }

  public void traverseInOrder() {
    if (Objects.isNull(this.root)) {

    }
  }

}