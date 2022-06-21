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
    } else {
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
  public static <E> List<E> depthFirstValues(BinaryTreeNode<E> root) {
    List<E> result = new LinkedList<>();
    if (Objects.isNull(root)) {
      return result;
    }
    LinkedList<BinaryTreeNode<E>> stack = new LinkedList<>();
    stack.addFirst(root);
    while (!stack.isEmpty()) {
      BinaryTreeNode<E> top = stack.pollFirst();

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
  public static <E> List<E> breadthFirstValues(BinaryTreeNode<E> root) {
    List<E> result = new LinkedList<>();
    if (Objects.isNull(root)) {
      return result;
    }
    LinkedList<BinaryTreeNode<E>> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryTreeNode<E> current = queue.pollFirst();
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

  public static <E> List<LinkedList<E>> levelOrder(BinaryTreeNode<E> head) {
    if (head == null) {
      return Collections.emptyList();
    }
    List<LinkedList<E>> result = new ArrayList<>();
    Queue<BinaryTreeNode<E>> q = new LinkedList<>();
    q.add(head);
    while (!q.isEmpty()) {
      int levelSize = q.size();
      LinkedList<E> levelValues = new LinkedList<>();
      for (var i = 0; i < levelSize; i++) {
        var current = q.poll();
        levelValues.add(current.getData());
        if (Objects.nonNull(current.getLeft())) {
          q.add(current.getLeft());
        }
        if (Objects.nonNull(current.getRight())) {
          q.add(current.getRight());
        }
      }
      result.add(levelValues);
    }
    return result;
  }

  public boolean isSymmetric() {
    return BinaryTree.isSymmetric(this.root, this.root);
  }

  public static <E> boolean isSymmetric(BinaryTreeNode<E> node1, BinaryTreeNode<E> node2) {
    if (Objects.isNull(node1) && Objects.isNull(node2)) {
      return true;
    }

    return Objects.nonNull(node1) &&
      Objects.nonNull(node2) &&
      valuesEqual(node1.getData(), node2.getData()) &&
      isSymmetric(node1.getLeft(), node2.getRight()) &&
      isSymmetric(node1.getRight(), node2.getLeft());

  }

  private static <E> boolean valuesEqual(E data, E data1) {
    if (data.getClass().getTypeName().equals("java.lang.String")) {
      return data.equals(data1);
    } else {
      return data == data1;
    }
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

  public static <E> int getHeight(BinaryTreeNode<E> node) {
    if (Objects.isNull(node)) {
      return -1;
    }
    return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
  }

  public static Number findMax_iterative(BinaryTreeNode<? extends Number> root) {
    if(root == null) {
      throw new RuntimeException("Root is null");
    }
    while(root.getRight() != null) {
      root = root.getRight();
    }

    return root.getData();
  }
  public static Number findMax(BinaryTreeNode<? extends Number> root) {
    if(root == null) {
      throw new RuntimeException("Root is null");
    }
    if(root.getRight() == null) {
      return root.getData();
    }

    return findMax(root.getRight());
  }

  public static Number findMin(BinaryTreeNode<? extends Number> root) {
    if(root == null) {
      throw new RuntimeException("Root is null");
    }
    if(Objects.isNull(root.getLeft())) {
      return root.getData();
    }
    return BinaryTree.findMin(root.getLeft());
  }

  public static Number findMin_Iterative(BinaryTreeNode<? extends Number> root) {
    if(root == null) {
      throw new RuntimeException("Root is null");
    }
    BinaryTreeNode<? extends Number> current = root;
    while(current.getLeft() != null) {
      current = current.getLeft();
    }

    return current.getData();
  }

  public static <E> boolean areIdentical(BinaryTreeNode<E> root1, BinaryTreeNode<E> root2) {
    if(root1 == null && root2 == null) {
      return true;
    }

    return root1 != null &&
      root2 != null &&
      valuesEqual(root1.getData(), root2.getData()) &&
      areIdentical(root1.getLeft(), root2.getLeft()) &&
      areIdentical(root1.getRight(), root2.getRight());

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
