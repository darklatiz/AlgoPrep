package mx.com.geekflu.algo.prep.data.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Helpers {

  private Helpers(){}

  public static List<List<String>> createListOfListsFromString(String rawData, String colSplitter, String rowSplitter) {
    List<List<String>> data = new ArrayList<>();
    for(String row : rawData.split(rowSplitter)) {
      List<String> cols = new ArrayList<>();
      for (String col : row.split(colSplitter)) {
        cols.add(col.trim());
      }
      data.add(cols);
    }
    return data;
  }

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

  public static String createStringFromList(List<Boolean> booleans, String separator) {
    return booleans.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(separator));
  }
}
