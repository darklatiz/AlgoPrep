package mx.com.geekflu.algo.prep;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.heap.MaxHeap;
import mx.com.geekflu.algo.prep.data.heap.MinHeap;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class HeapTest {

  @Test
  public void test_min_heap_creation() {
    MinHeap<Integer> minHeap = new MinHeap<>();
    Assert.assertNotNull(minHeap);
    Assert.assertTrue(minHeap.isEmpty());
    Assert.assertNull(minHeap.getMin());
  }

  @Test
  public void test_max_heap_creation() {
    MaxHeap<Float> maxHeap = new MaxHeap<>();
    Assert.assertNotNull(maxHeap);
    Assert.assertTrue(maxHeap.isEmpty());
    Assert.assertNull(maxHeap.getMax());
  }

  @Test
  public void test_min_heap_insertion_integer() {
    int initialSize = 100_000;
    MinHeap<Integer> minHeap = new MinHeap<>(initialSize);
    List<Integer> integerList = new ArrayList<>();
    Assert.assertNotNull(minHeap);

    log.info("Start inserting on MinHeaP...");

    for (var i = 0; i < initialSize; i++) {
      var data = RandomUtils.nextInt(0, 200_000);
      minHeap.insert(data);
      integerList.add(data);
    }
    integerList.add(-1);

    List<Integer> orderedList = integerList.stream()
      .sorted()
      .collect(Collectors.toList());

    minHeap.insert(-1);

    log.info("Finished inserting -1...");
    Assert.assertEquals(Integer.valueOf(-1), minHeap.getMin());

    for (var num : orderedList) {
      Integer min = minHeap.extractMin();
      Assert.assertEquals(num, min);
    }
  }

  @Test
  public void test_max_heap_insertion_integer() {
    int initialSize = 100_000;
    MaxHeap<Integer> maxHeap = new MaxHeap<>(initialSize);
    List<Integer> integerList = new ArrayList<>();
    Assert.assertNotNull(maxHeap);

    log.info("Start inserting on MinHeaP...");

    for (var i = 0; i < initialSize; i++) {
      var data = -1 * RandomUtils.nextInt(1, 200_0000);
      maxHeap.insert(data);
      integerList.add(data);
    }
    integerList.add(1);
    integerList.add(1000);

    List<Integer> orderedList = integerList.stream()
      .sorted(Comparator.reverseOrder())
      .collect(Collectors.toList());

    maxHeap.insert(1);
    maxHeap.insert(1000);

    log.info("Finished inserting -1...");
    Assert.assertEquals(Integer.valueOf(1000), maxHeap.getMax());

    for (var num : orderedList) {
      Integer min = maxHeap.extractMax();
      Assert.assertEquals(num, min);
    }
  }

  @Test
  public void test_min_heap_insert_complex_object() {
    int initialSize = 150_000;
    MinHeap<Item> minHeap = new MinHeap<>(initialSize);
    List<Item> itemList = new ArrayList<>();
    Assert.assertNotNull(minHeap);

    for (var i = 0; i < initialSize; i++) {
      Item item = Item.builder()
        .description(RandomStringUtils.randomAlphabetic(10))
        .price(RandomUtils.nextFloat(0, 5000))
        .qty(RandomUtils.nextInt(1, 100))
        .build();

      itemList.add(item);
      minHeap.insert(item);

    }

    Item irwmMinusOne = Item.builder()
      .description(RandomStringUtils.randomAlphabetic(10))
      .price(-1.0f)
      .qty(-1)
      .build();
    minHeap.insert(irwmMinusOne);

    itemList.add(irwmMinusOne);

    log.info("Finished insertion in Heap");
    List<Item> orderedList = itemList.stream()
      .sorted()
      .collect(Collectors.toList());

    Assert.assertEquals(minHeap.getMin(), irwmMinusOne);

    for (Item item :
      orderedList) {
      Item fromHeap = minHeap.extractMin();
      Assert.assertEquals(item.getPrice(), fromHeap.getPrice());
    }


  }

  @Test
  public void test_max_heap_insert_complex_object() {
    int initialSize = 150_000;
    MaxHeap<Item> maxHeap = new MaxHeap<>(initialSize);
    List<Item> itemList = new ArrayList<>();
    Assert.assertNotNull(maxHeap);

    for (var i = 0; i < initialSize; i++) {
      Item item = Item.builder()
        .description(RandomStringUtils.randomAlphabetic(10))
        .price(-1 * RandomUtils.nextFloat(0, 5000))
        .qty(RandomUtils.nextInt(1, 100))
        .build();

      itemList.add(item);
      maxHeap.insert(item);

    }

    Item irwmPlusOne = Item.builder()
      .description(RandomStringUtils.randomAlphabetic(10))
      .price(1.0f)
      .qty(1)
      .build();
    maxHeap.insert(irwmPlusOne);

    itemList.add(irwmPlusOne);

    log.info("Finished insertion in Heap");
    List<Item> orderedList = itemList.stream()
      .sorted(Comparator.reverseOrder())
      .collect(Collectors.toList());

    Assert.assertEquals(maxHeap.getMax(), irwmPlusOne);

    for (Item item :
      orderedList) {
      Item fromHeap = maxHeap.extractMax();
      Assert.assertEquals(item.getPrice(), fromHeap.getPrice());
    }
  }


}

@Setter
@Getter
@Builder
@ToString
class Item implements Comparable<Item> {
  private Integer qty;
  private String description;
  private Float price;

  @Override
  public int compareTo(Item other) {
    return this.price.compareTo(other.getPrice());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Item item = (Item) o;

    if (!qty.equals(item.qty)) return false;
    if (!description.equals(item.description)) return false;
    return price.equals(item.price);
  }

  @Override
  public int hashCode() {
    int result = qty.hashCode();
    result = 31 * result + description.hashCode();
    result = 31 * result + price.hashCode();
    return result;
  }
}
