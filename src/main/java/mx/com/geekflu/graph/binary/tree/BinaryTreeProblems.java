package mx.com.geekflu.graph.binary.tree;

import mx.com.geekflu.algo.prep.data.core.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeProblems {

  /* Given the root of a binary tree, return all root-to-leaf paths in any order.
   * A leaf is a node with no children.
   *
   *                                  [ 1 ]
   *                                /       \
   *                             [ 2 ]    [ 3 ]
   *                                 \
   *                               [ 5 ]
   *
   * out = [["1->2->5", "1->3"]]
   */
  public static List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    LinkedList<String> pathStack = new LinkedList<>();
    LinkedList<TreeNode> traversalStack = new LinkedList<>();
    List<String> paths = new ArrayList<>();
    traversalStack.offerFirst(root);
    pathStack.offerFirst(root.getData().toString());
    while (!traversalStack.isEmpty()) {
      TreeNode node = traversalStack.poll();
      String path = pathStack.poll();

      if (node.getLeft() == null && node.getRight() == null) {
        paths.add(path);
      }

      if (node.getRight() != null) {
        traversalStack.offerFirst(node.getRight());
        pathStack.offerFirst(path + "->" + node.getRight().getData());
      }

      if (node.getLeft() != null) {
        traversalStack.offerFirst(node.getLeft());
        pathStack.offerFirst(path + "->" + node.getLeft().getData());
      }

    }
    return paths;
  }

  /* Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that
   * the sum of all the node values of that path equals ‘S’.
   *
   *                                  [ 12 ]
   *                                /       \
   *                             [ 7 ]      [ 1 ]
   *                                 \       /   \
   *                               [ 9 ] [ 10 ] [ 5 ]
   * s = 23
   * out = true
   *
   * s: 16
   * out: false
   */
  public static boolean binaryTreeHasSumPaths(TreeNode<Integer> root, int sumTarget, boolean isIterative) {
    if (isIterative) {
      return btHasSumPath_it(root, sumTarget);
    } else {
      return btHasCumPath_recursive(root, sumTarget);
    }
  }

  private static boolean btHasCumPath_recursive(TreeNode<Integer> root, int sumTarget) {
    if (root == null) {
      return false;
    }

    sumTarget = sumTarget - root.getData();

    if (root.getLeft() == null && root.getRight() == null) {
      return sumTarget == 0;
    }

    return btHasCumPath_recursive(root.getLeft(), sumTarget) || btHasCumPath_recursive(root.getRight(), sumTarget);
  }

  private static boolean btHasSumPath_it(TreeNode<Integer> root, int sumTarget) {
    if (root == null) {
      return false;
    }

    LinkedList<TreeNode<Integer>> traversalStack = new LinkedList<>();
    traversalStack.offerFirst(root);

    LinkedList<Integer> sums = new LinkedList<>();
    sums.offerFirst(root.getData());

    while (!traversalStack.isEmpty()) {

      TreeNode<Integer> current = traversalStack.pollFirst();
      int stackSum = sums.pollFirst();

      if (current.getLeft() == null && current.getRight() == null && stackSum == sumTarget) {
        return true;
      }

      if (current.getRight() != null) {
        traversalStack.offerFirst(current.getRight());
        sums.offerFirst(stackSum + current.getRight().getData());
      }

      if (current.getLeft() != null) {
        traversalStack.offerFirst(current.getLeft());
        sums.offerFirst(stackSum + current.getLeft().getData());
      }

    }
    return false;

  }

  public static List<List<Integer>> findPaths(TreeNode<Integer> root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();

    LinkedList<TreeNode<Integer>> traverse = new LinkedList<>();
    traverse.offerFirst(root);

    LinkedList<List<Integer>> sums = new LinkedList<>();
    List<Integer> initial = new ArrayList<Integer>();
    initial.add(root.getData());
    sums.offerFirst(initial);

    while (!traverse.isEmpty()) {
      TreeNode<Integer> current = traverse.pollFirst();
      List<Integer> sumPaths = sums.pollFirst();

      if (current.getLeft() == null && current.getRight() == null) {
        int finalSum = sumPaths != null ? sumPaths.stream().mapToInt(Integer::intValue)
          .sum() : 0;
        if (finalSum == sum) {
          allPaths.add(sumPaths);
        }
      }

      if (current.getRight() != null) {
        traverse.offerFirst(current.getRight());
        List<Integer> nPath = new ArrayList<>(sumPaths);
        nPath.add(current.getRight().getData());
        sums.offerFirst(nPath);
      }

      if (current.getLeft() != null) {
        traverse.offerFirst(current.getLeft());
        List<Integer> nPath = new ArrayList<>(sumPaths);
        nPath.add(current.getLeft().getData());
        sums.offerFirst(nPath);
      }

    }

    return allPaths;
  }
}
