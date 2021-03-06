package mx.com.geekflu.algo.prep.data.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Helpers {

  private Helpers(){}

  public static int[][] create2dIntArray(String rawData, String colSplitter, String rowSplitter) {
    String[] rows = rawData.split(rowSplitter);
    int colsSize = rows[0].split(colSplitter).length;
    int[][] nums = new int[rows.length][colsSize];
    for(int i = 0; i < rows.length; i++) {
      String[] cols = rows[i].split(colSplitter);
      for (int j = 0; j < cols.length; j++) {
        nums[i][j] = Integer.parseInt(cols[j]);
      }
    }
    return nums;
  }

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

  public static int[] createArrayOfIntegersFromString(String input, String splitter) {
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
