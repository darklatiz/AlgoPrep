package mx.com.geekflu.algo.prep.data.heap;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.ifc.AbstractHeap;

@Slf4j
public class MinHeap<E extends Comparable<E>> implements AbstractHeap<E> {

  private E[] theHeap;
  public static final int DEFAULT_SIZE = 10;
  private int size;
  private int currentSizeLimit;

  public MinHeap() {
    this.theHeap = (E[]) new Comparable[DEFAULT_SIZE];
    this.currentSizeLimit = DEFAULT_SIZE;
  }

  public MinHeap(int initialSize) {
    this.theHeap = (E[]) new Comparable[DEFAULT_SIZE];
    this.currentSizeLimit = DEFAULT_SIZE;
  }



  @Override
  public E getMax() {
    throw new UnsupportedOperationException("This a Min heap, for the moment is not implemented...");
  }

  @Override
  public E getMin() {
    if (isEmpty()) {
      return null;
    }
    return this.theHeap[0];
  }

  @Override
  public E extractMin() {
    return null;
  }

  @Override
  public E extractMax() {
    throw new UnsupportedOperationException("This a Min heap, for the moment is not implemented...");
  }

  @Override
  public void insert(E data) {
    if (isEmpty()) {
      this.theHeap[0] = data;
      this.size++;
      return;
    }
    // insert in the last position then heapify up
    // we are using size because is the next element of end element
    ensureCapacity();
    this.theHeap[size] = data;
    int i = this.size;
    int parent = parent(size);
    while (i > 0 && this.theHeap[parent].compareTo(this.theHeap[i]) > 0) {
      swap(parent,  i);
      i = parent;
      parent = parent(parent);
    }
    this.size++;
  }

  private void ensureCapacity() {
    if (size >= currentSizeLimit) {
      E[] nArray = (E[]) new Comparable[size + DEFAULT_SIZE];
      System.arraycopy(this.theHeap, 0, nArray, 0, this.theHeap.length);
      this.theHeap = nArray;
    }
  }

  @Override
  public void delete(E data) {

  }

  /**
   *
   * @param index
   * @return
   */
  @Override
  public int getLeft(int index) {
    return (2 * index) + 1;
  }

  @Override
  public int getRight(int index) {
    return (2 * index) + 2;
  }

  @Override
  public int parent(int index) {
    if (index < 0) {
      throw new RuntimeException("Index Should not be negative...");
    }
    return (int) Math.floor((double) (index - 1) / 2);
  }

  @Override
  public boolean isEmpty() {
    return size <= 0;
  }

  @Override
  public void swap(int i, int j) {
    var temp = this.theHeap[i];
    this.theHeap[i] = this.theHeap[j];
    this.theHeap[j] = temp;
  }

}
