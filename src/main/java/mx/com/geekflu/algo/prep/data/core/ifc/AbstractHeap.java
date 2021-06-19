package mx.com.geekflu.algo.prep.data.core.ifc;


public interface AbstractHeap<E> {

  // peek like methods
  E getMax();
  E getMin();

  // pop like methods
  E extractMin();
  E extractMax();

  void insert(E data);
  void delete(E data);

  int getLeft(int index);
  int getRight(int index);
  int parent(int index);
  boolean isEmpty();
  void swap(int i, int j);

}
