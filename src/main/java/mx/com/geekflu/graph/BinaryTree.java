package mx.com.geekflu.graph;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.ifc.Printable;
import mx.com.geekflu.graph.core.BinaryTreeNode;
import mx.com.geekflu.graph.core.Traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

@Slf4j
@Getter
public class BinaryTree<T> implements Printable {

  private BinaryTreeNode<T> root;

  public BinaryTree(BinaryTreeNode<T> head) {
    this.root = head;
  }

  public List<T> treeTraversal(Traversal traversal) {
    if (root != null) {
      if (traversal == Traversal.IN_ORDER) {
        return inOrderTraversal(this.root, new ArrayList<>());
      } else if (traversal == Traversal.PRE_ORDER) {
        return preOrderTraversal(this.root, new ArrayList<>());
      } else {
        return postOrderTraversal(this.root, new ArrayList<>());
      }
    }else {
      return Collections.emptyList();
    }
  }

  private List<T> postOrderTraversal(BinaryTreeNode<T> node, List<T> values) {
    if (Objects.isNull(node)) {
      return values;
    }
    postOrderTraversal(node.getLeft(), values);
    postOrderTraversal(node.getRight(), values);
    values.add(node.getData());
    return values;
  }

  private List<T> preOrderTraversal(BinaryTreeNode<T> node, List<T> values) {
    if (Objects.isNull(node)) {
      return values;
    }
    values.add(node.getData());
    preOrderTraversal(node.getLeft(), values);
    preOrderTraversal(node.getRight(), values);
    return values;
  }

  private List<T> inOrderTraversal(BinaryTreeNode<T> node, List<T> values) {
    if (Objects.isNull(node)) {
      return values;
    }
    inOrderTraversal(node.getLeft(), values);
    values.add(node.getData());
    inOrderTraversal(node.getRight(), values);
    return values;
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
    stack.addFirst(root);
    while (!stack.isEmpty()) {
      BinaryTreeNode<T> top = stack.pollFirst();

      if (Objects.nonNull(top.getRight())) {
        stack.addFirst(top.getRight());
      }
      if (Objects.nonNull(top.getLeft())) {
        stack.addFirst(top.getLeft());
      }
      result.add(top.getData());
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
    queue.add(this.root);
    while (!queue.isEmpty()) {
      BinaryTreeNode<T> current = queue.pollFirst();
      if (Objects.nonNull(current.getLeft())) {
        queue.add(current.getLeft());
      }

      if (Objects.nonNull(current.getRight())) {
        queue.add(current.getRight());
      }
      result.add(current.getData());
    }
    return result;
  }

  public List<LinkedList<T>> levelOrder() {
    if(this.root == null) {
      return Collections.emptyList();
    }
    List<LinkedList<T>> result = new ArrayList<>();
    Queue<BinaryTreeNode<T>> q = new LinkedList<>();
    q.add(this.root);
    while(!q.isEmpty()) {
      int levelSize = q.size();
      LinkedList<T> levelValues = new LinkedList<>();
      for(var i = 0; i < levelSize; i++) {
        var current = q.poll();
        levelValues.add(current.getData());
        if(Objects.nonNull(current.getLeft())) {
          q.add(current.getLeft());
        }
        if(Objects.nonNull(current.getRight())) {
          q.add(current.getRight());
        }
      }
      result.add(levelValues);
    }
    return result;
  }

  public static <E> int size(BinaryTreeNode<E> binaryTreeNode) {
    if (Objects.isNull(binaryTreeNode)) {
      return 0;
    }
    return size(binaryTreeNode.getLeft()) + size(binaryTreeNode.getRight()) + 1;
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
