package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.sorting.MergeSort;
import mx.com.geekflu.algo.prep.sorting.SelectionSort;
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

  @Test
  public void test_selection_sort(){
    var nums = Util.generatePrimitiveArray(30);
    var numsCopy = Arrays.copyOf(nums, nums.length);
    log.info("Array before sort: {}", Arrays.toString(nums));
    SelectionSort.sort(nums);
    log.info("Array after sort: {}", Arrays.toString(nums));
    Arrays.sort(numsCopy);
    Assert.assertArrayEquals(numsCopy, nums);


    int[] arr = {5,4,1,0,5,95,4,-100,200,0};
    int[] copy = Arrays.copyOf(arr, arr.length);
    SelectionSort.sort(arr);
    Arrays.sort(copy);
    Assert.assertArrayEquals(copy, arr);

    int[] nullArr = null;
    SelectionSort.sort(nullArr);
    Assert.assertNull(nullArr);
  }

}
