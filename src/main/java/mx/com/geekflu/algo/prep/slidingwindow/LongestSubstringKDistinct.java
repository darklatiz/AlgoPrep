package mx.com.geekflu.algo.prep.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

  private LongestSubstringKDistinct() {}

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

  public static String longestSubstring(String str) {
    Map<Character, Integer> charsPosition = new HashMap<>();
    int windowStart = 0;
    int globalStart = 0;
    int globalEnd = 0;
    int currentSize = 0;
    int globalSize = 0;
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      Character current = str.charAt(windowEnd);
      if (!charsPosition.containsKey(current)) {
        // we store current char's position
        charsPosition.put(current, windowEnd);
      }else {
        currentSize = windowEnd - windowStart;
        if (currentSize > globalSize) {
          globalSize = currentSize;
          globalStart = windowStart;
          globalEnd = windowEnd - 1;
        }
        windowStart = charsPosition.get(current) + 1;
        currentSize -= charsPosition.get(current);
        charsPosition.put(current, windowEnd);
      }
    }
    return globalStart + ", " + globalEnd;
  }

}
