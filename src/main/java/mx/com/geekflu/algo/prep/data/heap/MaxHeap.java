package mx.com.geekflu.algo.prep.data.heap;

import mx.com.geekflu.algo.prep.data.core.ifc.AbstractHeap;
import mx.com.geekflu.algo.prep.data.core.ifc.Maximum;

@SuppressWarnings("ALL")
public class MaxHeap<E extends Comparable> extends AbstractHeap<E> implements Maximum<E> {

  public MaxHeap() {
    this.theHeap = (E[]) new Comparable[DEFAULT_SIZE];
    this.currentSizeLimit = DEFAULT_SIZE;
  }

  public MaxHeap(int initialSize) {
    this.theHeap = (E[]) new Comparable[initialSize];
    this.currentSizeLimit = initialSize;
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
    while (i > 0 && this.theHeap[parent].compareTo(this.theHeap[i]) < 0) {
      swap(parent,  i);
      i = parent;
      parent = parent(parent);
    }
    this.size++;
  }

  @Override
  public E getMax() {
    if (isEmpty()) {
      return null;
    }
    return this.theHeap[0];
  }

  @Override
  public E extractMax() {
    if (isEmpty()) {
      return null;
    }

    //copy last to top
    var i = 0;

    if (this.size == 2 && this.theHeap[0].compareTo(this.theHeap[1]) < 0) {
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
          if (this.theHeap[left].compareTo(this.theHeap[right]) >= 0) {
            if (this.theHeap[left].compareTo(this.theHeap[i]) >= 0) {
              swap(left, i);
              i = left;
            } else {
              break;
            }
          } else {
            if (this.theHeap[right].compareTo(this.theHeap[i]) >= 0) {
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
}
