package mx.com.geekflu.algo.prep.data.core.ifc;

public interface Stackable<T> extends Printable {
  T pop();
  void push(T data);
  T peek();
  void clear();
  boolean isEmpty();
  int size();
}
