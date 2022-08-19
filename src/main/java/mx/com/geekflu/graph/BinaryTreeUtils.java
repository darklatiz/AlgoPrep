package mx.com.geekflu.graph;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.linked.list.LinkedList;
import mx.com.geekflu.graph.core.BinaryTreeNode;

@Slf4j
public class BinaryTreeUtils {

  public static final int FACTOR = 200;

  private BinaryTreeUtils() {
  }


  public static BinaryTree<Integer> createBinaryTreeIntegers(int size) {
    int idx = 0;
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(idx++);
    LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
    queue.append(root);

    while (size > 0 && !queue.isEmpty()) {
      BinaryTreeNode<Integer> first = queue.getFirst();
      first.setLeft(new BinaryTreeNode<>(idx++));
      first.setRight(new BinaryTreeNode<>(idx++));
      queue.append(first.getLeft());
      queue.append(first.getRight());
      size--;
    }
    return new BinaryTree<>(root);
  }

}
