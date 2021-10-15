package mx.com.geekflu.algo.prep.slidingwindow;

public class AverageOfSubarrayOfSizeK {

  private AverageOfSubarrayOfSizeK() {}

  public static double[] findAverages(int k, Integer[] arr) {
    double[] result = new double[arr.length - k + 1];
    double windowSum = 0;
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];
      if(windowEnd >= k - 1) {
        result[windowStart] = windowSum / k;
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return result;
  }

}
