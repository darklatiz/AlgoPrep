package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.sorting.MergeSort;
import mx.com.geekflu.algo.prep.util.Util;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class SortingTest {

  @Test
  public void test_merge_sort_copying_space() {
    var array = Util.generatePrimitiveArray(9);
    log.info("Array to be sort: {}", Arrays.toString(array));
    var sorted = MergeSort.mergeSort(array);
    log.info("Array sorted: {}", Arrays.toString(sorted));
    Arrays.sort(array);
    Assert.assertArrayEquals(array, sorted);
  }

}
