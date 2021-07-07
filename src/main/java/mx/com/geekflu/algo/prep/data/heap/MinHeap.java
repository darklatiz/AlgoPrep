package mx.com.geekflu.algo.prep.data.heap;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.ifc.AbstractHeap;
import mx.com.geekflu.algo.prep.data.core.ifc.Minimal;

import java.util.Comparator;

@SuppressWarnings("ALL")
@Slf4j
public class MinHeap<E> extends AbstractHeap<E> implements Minimal<E> {

  public MinHeap(Comparator<E> comparator) {
    this.theHeap = (E[]) new Object[DEFAULT_SIZE];
    this.currentSizeLimit = DEFAULT_SIZE;
    this.comparator = comparator;
  }

  public MinHeap(int initialSize, Comparator<E> comparator) {
    this.theHeap = (E[]) new Object[initialSize];
    this.currentSizeLimit = initialSize;
    this.comparator = comparator;
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

    if (isEmpty()) {
      return null;
    }

    //copy last to top
    var i = 0;

    if (this.size == 2 && this.comparator.compare(this.theHeap[0], this.theHeap[1]) > 0) {
      swap(0, 1);
    }

    E top = this.theHeap[0];

    if (this.size > 1) {
      this.theHeap[0] = this.theHeap[size - 1];
      this.theHeap[size - 1] = null;
      this.size--;
      //we start bubbling down
      while (hasChildren(i)) {
        if (this.size > 2) {
          int left = getLeft(i);
          int right = getRight(i);
          //left
          if (this.comparator.compare(this.theHeap[left], this.theHeap[right]) <= 0) {
            if (this.comparator.compare(this.theHeap[left], this.theHeap[i]) <= 0) {
              swap(left, i);
              i = left;
            } else {
              break;
            }
          } else {
            if (this.comparator.compare(this.theHeap[right], this.theHeap[i]) <= 0) {
              swap(right, i);
              i = right;
            }else {
              break;
            }
          }
        }
      }
    }
    return top;
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
    while (i > 0 && this.comparator.compare(this.theHeap[parent], this.theHeap[i]) > 0) {
      swap(parent,  i);
      i = parent;
      parent = parent(parent);
    }
    this.size++;
  }

}
