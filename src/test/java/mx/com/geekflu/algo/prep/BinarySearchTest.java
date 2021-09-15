package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.binary.search.BinarySearch;
import mx.com.geekflu.algo.prep.util.Util;
import org.junit.Assert;
import org.junit.Test;


@Slf4j
public class BinarySearchTest {

  @Test
  public void test_binary_search_int() {
    Integer[] array = Util.generateArray(1000, true);
    array[999] = 10001;
    int targetIndex = BinarySearch.binarySearch(array, 10001);
    Assert.assertEquals(999, targetIndex);

    targetIndex = BinarySearch.binarySearch(array, -12345);
    Assert.assertEquals(-1, targetIndex);

    Assert.assertEquals(-1, BinarySearch.binarySearch(null, 1));

    Integer[] zero = new Integer[0];
    Assert.assertEquals(-1, BinarySearch.binarySearch(zero, 1));
  }

  @Test
  public void test_binary_search_int_descending() {
    Integer[] array = new Integer[]{1000, 999, 888, 777, 666, 555, 444, 333, 222, 111, 99, 88, 77, 66, 55, 44, 33, 22, 11, 9, 8, 7};
    int targetIndex = BinarySearch.binarySearch(array, 333);
    Assert.assertEquals(7, targetIndex);
    Assert.assertEquals(0, BinarySearch.binarySearch(array, 1000));
    Assert.assertEquals(21, BinarySearch.binarySearch(array, 7));
    Assert.assertEquals(15, BinarySearch.binarySearch(array, 44));
  }

}
