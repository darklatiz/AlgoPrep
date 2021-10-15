package mx.com.geekflu.algo.prep.slidingwindow;

public class MaxSumSubArrayOfSizeK {

  private MaxSumSubArrayOfSizeK() {}

  public static int findMaxSumSubArray_brute(int k, int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length - k; i++) {
      int windowSum = 0;
      for (int j = i; j < i + k; j++) {
        windowSum += arr[j];
      }
      sum = Math.max(sum, windowSum);
    }
    return sum;
  }

  public static int findMaxSumSubArray(int k, int[] arr) {
    int windowSum = 0;
    int windowsStart = 0;
    int maxSum = 0;
    for (int windowEnd = 0; windowEnd < arr.length ; windowEnd++) {
      windowSum += arr[windowEnd];
      if (windowEnd >= k - 1) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= arr[windowsStart];
        windowsStart++;
      }
    }
    return maxSum;
  }
}
