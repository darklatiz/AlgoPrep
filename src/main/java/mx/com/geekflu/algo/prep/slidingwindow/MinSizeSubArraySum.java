package mx.com.geekflu.algo.prep.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinSizeSubArraySum {

  public static int findMinSubArray(int target, int[] arr) {
    int windowStart = 0;
    int windowSum = 0;
    int minLength = Integer.MAX_VALUE;
    double aa = 444.56;
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

  private static String StringDuplicates(String text) {
    if (text.length() == 1) {
      return text;
    }

    if (text.substring(0,1).equals(text.substring(1,2))) {
      return StringDuplicates(text.substring(1));
    }
    else {
      return text.substring(0,1) + StringDuplicates(text.substring(1));
    }
  }

  public static void main( String args[] ) {
    String input1 = "Helloo";
    String output = StringDuplicates(input1);
    System.out.println("String after: " + output);

    int[] news = new int[100];
    System.out.println(news.length);
  }

}
