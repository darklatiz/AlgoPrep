package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.slidingwindow.AverageOfSubarrayOfSizeK;
import mx.com.geekflu.algo.prep.slidingwindow.MaxSumSubArrayOfSizeK;
import mx.com.geekflu.algo.prep.util.Util;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class SlidingWindow {

  @Test
  public void test_average_of_subarray_size_k() {
    Integer[] nums = Util.generateArray(100);
    log.info("{}", AverageOfSubarrayOfSizeK.findAverages(5, nums));
  }

  @Test
  public void test_max_sum_array_size_k() {
    int maxSum = MaxSumSubArrayOfSizeK.findMaxSumSubArray_brute(3, new int[] { 2, 1, 5, 1, 3, 2 });
    log.info("Max Sum on sub array of size K = {}", maxSum);
    Assert.assertEquals(9, maxSum);
    int maxSumOptimal = MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 });
    Assert.assertEquals(9, maxSumOptimal);
  }
}
