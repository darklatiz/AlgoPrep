package mx.com.geekflu.algo.prep.dynamic.programming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GridTraveler {

  private static Map<String, Long> memo;

  private GridTraveler() {}

  public static long brute(int row, int col) {
    if (row == 1 && col == 1) {
      return 1;
    }

    if (row == 0 || col == 0) {
      return 0;
    }

    return brute(row -1, col) + brute(row, col -1);

  }

  public static long memoized(int rows, int cols) {
    if (Objects.isNull(memo)) {
      memo = new HashMap<>();
    }

    String key = rows + "," + cols;
    if (memo.containsKey(key)) return memo.get(key);
    if (rows == 1 && cols == 1) return 1;
    if (rows == 0 || cols == 0) return 0;

    long result = memoized(rows - 1, cols) + memoized(rows, cols - 1);
    memo.put(key, result);
    return result;
  }

}
