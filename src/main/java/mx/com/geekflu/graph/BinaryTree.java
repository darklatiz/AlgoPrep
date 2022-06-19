package mx.com.geekflu.graph;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.ifc.Printable;
import mx.com.geekflu.algo.prep.data.linked.list.LinkedList;
import mx.com.geekflu.graph.core.BinaryTreeNode;
import mx.com.geekflu.graph.core.Traversal;

import java.util.Objects;

@Slf4j
@Getter
public class BinaryTree<T> implements Printable {

  private BinaryTreeNode<T> root;

  public BinaryTree(BinaryTreeNode<T> head) {
    this.root = head;
  }

  public static <E> void treeTraversal(BinaryTreeNode<E> root, Traversal traversal) {
    if (root != null) {
      if (traversal == Traversal.IN_ORDER) {
        inOrderTraversal(root);
      } else if (traversal == Traversal.PRE_ORDER) {
        preOrderTraversal(root);
      } else {
        postOrderTraversal(root);
      }
    }
  }

  private static <E> void postOrderTraversal(BinaryTreeNode<E> root) {
    inOrderTraversal(root.getLeft());
    inOrderTraversal(root.getRight());
    log.info("{} ", root.getData());
  }

  private static <E> void preOrderTraversal(BinaryTreeNode<E> root) {
    log.info("{} ", root.getData());
    inOrderTraversal(root.getLeft());
    inOrderTraversal(root.getRight());
  }

  private static <E> void inOrderTraversal(BinaryTreeNode<E> root) {
    inOrderTraversal(root.getLeft());
    log.info("{} ", root.getData());
    inOrderTraversal(root.getRight());
  }

  /**
   * Using an iterative approach we traverse the binary tree using DFS
   *
   * @return Tree traversal using DFS approach
   */
  public LinkedList<T> depthFirstValues() {
    LinkedList<T> result = new LinkedList<>();
    if (Objects.isNull(root)) {
      return result;
    }
    LinkedList<BinaryTreeNode<T>> stack = new LinkedList<>();
    stack.appendFirst(root);
    while (!stack.isEmpty()) {
      BinaryTreeNode<T> top = stack.getFirst();

      if (Objects.nonNull(top.getRight())) {
        stack.appendFirst(top.getRight());
      }
      if (Objects.nonNull(top.getLeft())) {
        stack.appendFirst(top.getLeft());
      }
      result.append(top.getData());
    }
    return result;
  }

  /**
   * Iterative Approach to ger values using BFS algorithm
   *
   * @return
   */
  public LinkedList<T> breadthFirstValues() {
    LinkedList<T> result = new LinkedList<>();
    if (Objects.isNull(this.root)) {
      return result;
    }
    LinkedList<BinaryTreeNode<T>> queue = new LinkedList<>();
    queue.append(this.root);
    while (!queue.isEmpty()) {
      BinaryTreeNode<T> current = queue.getFirst();
      if (Objects.nonNull(current.getLeft())) {
        queue.append(current.getLeft());
      }

      if (Objects.nonNull(current.getRight())) {
        queue.append(current.getRight());
      }
      result.append(current.getData());
    }
    return result;
  }

  public int getHeight() {
    return getHeight(this.root);
  }

  private int getHeight(BinaryTreeNode<T> node) {
    if (Objects.isNull(node)) {
      return 0;
    }
    return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
  }

  @Override
  public void print() {
    /**
     root
     /       \
     element1     element2
     /       \      /   \




     */
  }
}
