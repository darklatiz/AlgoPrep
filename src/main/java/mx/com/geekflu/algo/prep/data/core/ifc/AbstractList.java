package mx.com.geekflu.algo.prep.data.core.ifc;

import java.util.Collection;

public interface AbstractList<T> {

  T get(int position);
  T getFirst();
  T getLast();
  boolean append(T data);
  boolean appendFirst(T data);
  boolean insert(int position, T data);
  boolean remove(T data);
  boolean containsAll(Collection<T> elements);
  boolean contains(T data);
  boolean isEmpty();
  void clear();
  void print(Direction direction);
  void print();
  int size();


}
