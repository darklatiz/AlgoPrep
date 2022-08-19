package mx.com.geekflu.graph;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * @author tusroy
 * Date 06/20/2015
 *
 * Video link - https://youtu.be/ID00PMy0-vE
 *
 * Disjoint sets using path compression and union by rank
 * Supports 3 operations
 * 1) makeSet
 * 2) union
 * 3) findSet
 *
 * For m operations and total n elements time complexity is O(m*f(n)) where f(n) is
 * very slowly growing function. For most cases f(n) <= 4 so effectively
 * total time will be O(m). Proof in Coreman book.
 */
public class DisjointSet {
  private Map<Long, Node> map = new HashMap<>();

  @Getter
  @Setter
  static class Node {

    public Node(long data) {
      this.data = data;
    }

    long data;
    Node parent;
    int rank;

  }

  public void makeSet(long data) {
    var node = new Node(data);
    node.setParent(node);
    node.setRank(0);
    map.put(data, node);
  }

  /**
   * Finds the representative of this set
   */
  public long findSet(long data) {
    return findSet(map.get(data)).data;
  }

  /**
   * Find the representative recursively and does path
   * compression as well.
   */
  private Node findSet(Node node) {
    var parent = node.parent;
    if (parent == node) {
      return parent;
    }
    node.parent = findSet(node.parent);
    return node.parent;
  }

  /**
   * Combines two sets together to one.
   * Does union by rank
   *
   * @return true if data1 and data2 are in different set before union else false.
   */
  public boolean union(long data1, long data2) {
    var node1 = map.get(data1);
    var node2 = map.get(data2);

    var parent1 = findSet(node1);
    var parent2 = findSet(node2);


    //if they are part of same set do nothing
    if (parent1.data == parent2.data) {
      return false;
    }

    //else whoever's rank is higher becomes parent of other
    if (parent1.rank >= parent2.rank) {
      //increment rank only if both sets have same rank
      parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
      parent2.parent = parent1;
    } else {
      parent1.parent = parent2;
    }
    return true;
  }

}
