package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.TreeNode;
import mx.com.geekflu.graph.binary.tree.BinaryTreeProblems;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class BinaryTreeTest {

  @Test
  public void test_paths_binaryTree() {
    TreeNode<String> head = new TreeNode<>("L");
    head.setLeft(new TreeNode<>("U"));
    head.setRight(new TreeNode<>("I"));

    head.getLeft().setLeft(new TreeNode<>("S"));
    head.getLeft().getLeft().setRight(new TreeNode<>("T"));

    log.info("Paths = {}", BinaryTreeProblems.binaryTreePaths(head));
  }

  @Test
  public void test_has_bt_sum_psth() {
    /*
     *                                  [ 12 ]
     *                                /       \
     *                             [ 7 ]      [ 1 ]
     *                                 \       /   \
     *                               [ 9 ] [ 10 ] [ 5 ]
     */

    TreeNode<Integer> root = new TreeNode<>(12);
    root.setLeft(new TreeNode<>(7));
    root.setRight(new TreeNode<>(1));

    root.getLeft().setRight(new TreeNode<>(9));

    root.getRight().setLeft(new TreeNode<>(10));
    root.getRight().setRight(new TreeNode<>(5));


    Assert.assertTrue(BinaryTreeProblems.binaryTreeHasSumPaths(root, 23, true));
    Assert.assertTrue(BinaryTreeProblems.binaryTreeHasSumPaths(root, 23, false));

    Assert.assertFalse(BinaryTreeProblems.binaryTreeHasSumPaths(root, 16, true));
    Assert.assertFalse(BinaryTreeProblems.binaryTreeHasSumPaths(root, 16, false));

    Assert.assertFalse(BinaryTreeProblems.binaryTreeHasSumPaths(null, 16, false));
    Assert.assertFalse(BinaryTreeProblems.binaryTreeHasSumPaths(null, 16, false));


  }

  @Test
  public void tes_find_all_paths_sum() {

    /*
     *                                  [ 12 ]
     *                                /       \
     *                             [ 7 ]      [ 1 ]
     *                                 \       /   \
     *                               [ 9 ] [ 10 ] [ 5 ]
     */
    TreeNode<Integer> root = new TreeNode<>(12);
    root.setLeft(new TreeNode<>(7));
    root.setRight(new TreeNode<>(1));

    root.getLeft().setLeft(new TreeNode<>(4));

    root.getRight().setLeft(new TreeNode<>(10));
    root.getRight().setRight(new TreeNode<>(5));

    log.info("Paths with sum 23: {}", BinaryTreeProblems.findPaths(root, 23));
    log.info("Paths with sum 18: {}", BinaryTreeProblems.findPaths(root, 18));
    log.info("Paths with sum 1: {}", BinaryTreeProblems.findPaths(root, 1));
  }

}
