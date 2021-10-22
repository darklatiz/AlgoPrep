package mx.com.geekflu.algo.prep.slidingwindow;

public class MinSizeSubArraySum {

  public static int findMinSubArray(int target, int[] arr) {
    int windowStart = 0;
    int windowSum = 0;
    int minLength = Integer.MAX_VALUE;
    for (int windEnd = 0; windEnd < arr.length; windEnd++) {
      windowSum += arr[windEnd];
      while (windowSum >= target) {
        minLength = Math.min(minLength, windEnd - windowStart + 1);
        windowSum -= arr[windowStart];
        windowStart++;
      }

    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }

}
