package mx.com.geekflu.algo.prep.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

  public static int findLength(String str, int k) {
    int windowStart = 0;
    int maxLength = 0;
    Map<Character, Integer> charFrequency = new HashMap<>();

    for(int windowEnd = 0; windowEnd < str.length() ; windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0 ) + 1);
      while (charFrequency.size() > k) {
        char leftChar = str.charAt(windowStart);
        charFrequency.put(leftChar, charFrequency.getOrDefault(leftChar, 0 ) - 1);
        if (charFrequency.get(leftChar) == 0) {
          charFrequency.remove(leftChar);
        }
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }

}
