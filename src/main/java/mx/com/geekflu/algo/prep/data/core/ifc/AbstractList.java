package mx.com.geekflu.algo.prep.data.core.ifc;

import mx.com.geekflu.algo.prep.data.core.Node;

import java.util.Collection;

public interface AbstractList<T> {

  Node<T> get(int position);
  boolean append(T data);
  boolean appendFirst(T data);
  boolean insert(int position, T data);
  boolean remove(T dat);
  boolean containsAll(Collection<T> elements);
  boolean contains(T data);
  boolean isEmpty();
  void clear();
  void print(Direction direction);
  int size();


}
