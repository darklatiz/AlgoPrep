package mx.com.geekflu.algo.prep.data.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Helpers {

  private Helpers(){}

  public static int[] createArrayFromString(String input, String splitter) {
    String []sNums = input.split(splitter);
    return Arrays.stream(sNums)
        .map(Integer::parseInt)
        .collect(Collectors.toList())
        .stream().mapToInt(Integer::intValue)
        .toArray();
  }

  public static String createStringFromArray(int[] array, String separator) {
    return Arrays.stream(array)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(separator));
  }
}
