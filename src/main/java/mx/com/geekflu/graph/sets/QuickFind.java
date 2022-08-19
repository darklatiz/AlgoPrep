package mx.com.geekflu.graph.sets;

/**
 * Quick Find
 * This is the implementation of Disjoint Sets, Quick Find Algorithm
 */
public class QuickFind {

  private int[] roots;

  public QuickFind(int size) {
    this.roots = new int[size];
    for (int i = 0; i < size; i++) {
      this.roots[i] = i;
    }
  }

  /**
   * QuickFind O(1)
   * @param p
   * @return the root od the set
   */
  public int find(int p) {
    return this.roots[p];
  }

  public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if(rootP != rootQ) {
        for (int i = 0; i < this.roots.length; i++) {
          if(this.roots[i] == rootQ){
            this.roots[i] = rootP;
          }
        }
      }
  }

  public boolean connected(int p, int q){
    return find(p) == find(q);
  }
}
