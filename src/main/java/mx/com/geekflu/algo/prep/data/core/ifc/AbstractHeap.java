package mx.com.geekflu.algo.prep.data.core.ifc;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;

@Slf4j
public abstract class AbstractHeap<E> {

  protected E[] theHeap;
  public static final int DEFAULT_SIZE = 10;
  protected int size;
  protected int currentSizeLimit;
  protected Comparator<E> comparator;

  protected boolean hasChildren(int i) {
    return getLeft(i) < size - 1 || getRight(i) < size - 1;
  }

  protected void ensureCapacity() {
    if (size >= currentSizeLimit) {
      E[] nArray = (E[]) new Object[size + DEFAULT_SIZE];
      System.arraycopy(this.theHeap, 0, nArray, 0, this.theHeap.length);
      this.theHeap = nArray;
    }
  }

  protected int getLeft(int index) {
    return (2 * index) + 1;
  }

  protected int getRight(int index) {
    return (2 * index) + 2;
  }

  protected int parent(int index) {
    if (index < 0) {
      throw new RuntimeException("Index Should not be negative...");
    }
    return (int) Math.floor((double) (index - 1) / 2);
  }

  public boolean isEmpty() {
    return size <= 0;
  }

  protected void swap(int i, int j) {
    var temp = this.theHeap[i];
    this.theHeap[i] = this.theHeap[j];
    this.theHeap[j] = temp;
  }

  public abstract void insert(E data);

}
