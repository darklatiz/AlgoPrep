package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
import mx.com.geekflu.algo.prep.data.core.TreeNode;
import mx.com.geekflu.graph.binary.tree.BinaryTreeProblems;
=======
import mx.com.geekflu.graph.BinaryTree;
import mx.com.geekflu.graph.BinaryTreeUtils;
import mx.com.geekflu.graph.core.BinaryTreeNode;
>>>>>>> origin/master
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class BinaryTreeTest {

  @Test
<<<<<<< HEAD
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
=======
  public void test_depth_first_values() {
    BinaryTree<Integer> binaryTree = BinaryTreeUtils.createBinaryTreeIntegers(20);
    log.info("Depth First Values: {}", BinaryTree.depthFirstValues(binaryTree.getRoot()));

    log.info("Breadth First Values: {}" , BinaryTree.breadthFirstValues(binaryTree.getRoot()));

    log.info("Level Order BFS = {}", BinaryTree.levelOrder(binaryTree.getRoot()));
  }

  @Test
  public void test_depth_first_values_str() {

    BinaryTreeNode<Character> characterBinaryTreeNodeA = new BinaryTreeNode<>('a');
    BinaryTreeNode<Character> characterBinaryTreeNodeB = new BinaryTreeNode<>('b');
    BinaryTreeNode<Character> characterBinaryTreeNodeC = new BinaryTreeNode<>('c');
    characterBinaryTreeNodeA.setLeft(characterBinaryTreeNodeB);
    characterBinaryTreeNodeA.setRight(characterBinaryTreeNodeC);


    BinaryTreeNode<Character> characterBinaryTreeNodeD = new BinaryTreeNode<>('d');
    BinaryTreeNode<Character> characterBinaryTreeNodeE = new BinaryTreeNode<>('e');
    characterBinaryTreeNodeB.setLeft(characterBinaryTreeNodeD);
    characterBinaryTreeNodeB.setRight(characterBinaryTreeNodeE);

    BinaryTreeNode<Character> characterBinaryTreeNodeF = new BinaryTreeNode<>('f');
    BinaryTreeNode<Character> characterBinaryTreeNodeG = new BinaryTreeNode<>('g');
    characterBinaryTreeNodeC.setLeft(characterBinaryTreeNodeF);
    characterBinaryTreeNodeC.setRight(characterBinaryTreeNodeG);

    BinaryTree<Character> binaryTree = new BinaryTree<>(characterBinaryTreeNodeA);

    log.info("Height of a Binary tree - {}", binaryTree.getHeight());

  }

  @Test
  public void test_height_binary_tree() {

  }

  @Test
  public void test_is_symmetric() {
    BinaryTreeNode<Character> root = new BinaryTreeNode<>('a');
    BinaryTreeNode<Character> left = new BinaryTreeNode<>('b');
    BinaryTreeNode<Character> right = new BinaryTreeNode<>('b');

    root.setLeft(left);
    root.setRight(right);

    BinaryTreeNode<Character> lleft = new BinaryTreeNode<>('d');
    BinaryTreeNode<Character> lright = new BinaryTreeNode<>('e');
    BinaryTreeNode<Character> rleft = new BinaryTreeNode<>('e');
    BinaryTreeNode<Character> rright = new BinaryTreeNode<>('d');

    left.setLeft(lleft);
    left.setRight(lright);

    right.setLeft(rleft);
    right.setRight(rright);

    boolean symmetric = BinaryTree.isSymmetric(root, root);
    Assert.assertTrue(symmetric);
  }

  @Test
  public void test_is_identical() {
    BinaryTreeNode<Character> root = new BinaryTreeNode<>('a');
    BinaryTreeNode<Character> left = new BinaryTreeNode<>('b');
    BinaryTreeNode<Character> right = new BinaryTreeNode<>('b');

    root.setLeft(left);
    root.setRight(right);

    BinaryTreeNode<Character> lleft = new BinaryTreeNode<>('d');
    BinaryTreeNode<Character> lright = new BinaryTreeNode<>('e');
    BinaryTreeNode<Character> rleft = new BinaryTreeNode<>('d');
    BinaryTreeNode<Character> rright = new BinaryTreeNode<>('e');

    left.setLeft(lleft);
    left.setRight(lright);

    right.setLeft(rleft);
    right.setRight(rright);

    boolean areIdentical = BinaryTree.areIdentical(root, root);
    Assert.assertTrue(areIdentical);
>>>>>>> origin/master


  }

  @Test
<<<<<<< HEAD
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
=======
  public void find_min() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(15);
    BinaryTreeNode<Integer> left = new BinaryTreeNode<>(10);
    BinaryTreeNode<Integer> right = new BinaryTreeNode<>(20);

    root.setLeft(left);
    root.setRight(right);

    BinaryTreeNode<Integer> lleft = new BinaryTreeNode<>(8);
    BinaryTreeNode<Integer> lright = new BinaryTreeNode<>(12);
    BinaryTreeNode<Integer> rleft = new BinaryTreeNode<>(17);
    BinaryTreeNode<Integer> rright = new BinaryTreeNode<>(25);

    left.setLeft(lleft);
    left.setRight(lright);

    right.setLeft(rleft);
    right.setRight(rright);

    Number minRecursive = BinaryTree.findMin(root);
    log.info("Min: {}", minRecursive);
    Number min_iterative = BinaryTree.findMin_Iterative(root);
    log.info("Min: {}", min_iterative);
    Assert.assertEquals(minRecursive, min_iterative);

    Number maxRecursive = BinaryTree.findMax(root);
    log.info("Max: {}", maxRecursive);
    Number max_iterative = BinaryTree.findMax_iterative(root);
    log.info("Max: {}", max_iterative);
    Assert.assertEquals(maxRecursive, max_iterative);

>>>>>>> origin/master
  }

}
