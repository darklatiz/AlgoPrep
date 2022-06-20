package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.graph.BinaryTree;
import mx.com.geekflu.graph.BinaryTreeUtils;
import mx.com.geekflu.graph.core.BinaryTreeNode;
import org.junit.Test;

import java.util.LinkedList;

@Slf4j
public class BinaryTreeTest {

  @Test
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

}
