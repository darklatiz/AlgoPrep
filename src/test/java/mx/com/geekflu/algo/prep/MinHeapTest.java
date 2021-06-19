package mx.com.geekflu.algo.prep;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.heap.MinHeap;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class MinHeapTest {

  @Test
  public void test_min_heap_creation() {
    MinHeap<Integer> minHeap = new MinHeap<>();
    Assert.assertNotNull(minHeap);
    Assert.assertTrue(minHeap.isEmpty());
    Assert.assertNull(minHeap.getMin());
  }

  @Test
  public void test_min_heap_insertion() {
    MinHeap<Integer> minHeap = new MinHeap<>();
    Assert.assertNotNull(minHeap);

    minHeap.insert(10);
    minHeap.insert(3);
    minHeap.insert(1);
    minHeap.insert(15);
    minHeap.insert(2);
    minHeap.insert(0);
    minHeap.insert(-1);
    minHeap.insert(11);
    minHeap.insert(11);
    minHeap.insert(-11);
    minHeap.insert(-110);
  }

}

@Setter
@Getter
@Builder
class Item {
  private int qty;
  private String description;
  private float price;
}
