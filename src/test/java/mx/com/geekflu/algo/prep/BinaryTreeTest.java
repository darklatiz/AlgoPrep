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
    BinaryTree<Integer> binaryTree = BinaryTreeUtils.createBinaryTreeIntegers(10);
    log.info("Depth First Values");
    binaryTree.depthFirstValues();

    log.info("Breadth First Values Or Level traversal");
    binaryTree.breadthFirstValues();
    log.info("Level Order BFS = {}", binaryTree.levelOrder());
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
    LinkedList<Character> resDFS = binaryTree.depthFirstValues();
    LinkedList<Character> resBFS = binaryTree.breadthFirstValues();

    log.info("Height of a Binary tree - {}", binaryTree.getHeight());

  }

  @Test
  public void test_height_binary_tree() {

  }

}
