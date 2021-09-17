package mx.com.geekflu.algo.prep.binary.search;

import java.util.Objects;

public class FindSmallestLetter {

  /**
   * Se MD file for description, basically this is the same approach as ceiling problem but without the equal
   *
   * @param letters
   * @param target
   * @return
   */
  public static char findSmallestLetter(char[] letters, char target) {
    if (Objects.isNull(letters))
      return '-';
    if (letters.length <= 0)
      return '-';

    int start = 0;
    int end = letters.length - 1;

    while (start <= end) {
      int midIndex = start + (end - start) / 2;
      int midPointValue = letters[midIndex];

      // we search on the left so we adjust end pointer
      if (target < midPointValue) {
        end = midIndex - 1;
      } else {
        // it is on the right we adjust start
        start = midIndex + 1;
      }
    }

    if (start >= letters.length) {
      return letters[0];
    }
    return letters[start];
  }

}
