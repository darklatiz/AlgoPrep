package mx.com.geekflu.algo.prep;

import mx.com.geekflu.graph.sets.QuickFind;
import org.junit.Assert;
import org.junit.Test;

public class DisjointSetTest {

  @Test
  public void test_quick_find(){
    QuickFind quickFind = new QuickFind(10);

    quickFind.union(1, 2);
    quickFind.union(2, 5);
    quickFind.union(5, 6);
    quickFind.union(6, 7);
    quickFind.union(3, 8);
    quickFind.union(8, 9);

    Assert.assertTrue(quickFind.connected(1, 6));
    Assert.assertTrue(quickFind.connected(1, 5));
    Assert.assertFalse(quickFind.connected(4, 9));

  }

}
