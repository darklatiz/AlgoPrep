package mx.com.geekflu.algo.prep.dynamic.programming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GridTraveler {

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

  private static long memoized(int rows, int cols, Map<String, Long> memo) {
    if (Objects.isNull(memo)) {
      memo = new HashMap<>();
    }
    String key = rows + "," + cols;
    if (memo.containsKey(key)) return memo.get(key);
    if (rows == 1 && cols == 1) return 1;
    if (rows == 0 || cols == 0) return 0;

    long result = memoized(rows - 1, cols, memo) + memoized(rows, cols - 1, memo);
    memo.put(key, result);
    return result;
  }

  public static long memoized(int rows, int cols) {
    return memoized(rows, cols, new HashMap<>());
  }

}
