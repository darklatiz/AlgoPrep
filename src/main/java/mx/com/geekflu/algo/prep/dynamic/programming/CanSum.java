package mx.com.geekflu.algo.prep.dynamic.programming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CanSum {

  private CanSum() {}

  public static boolean brute(long sum, int[] nums) {
    if (sum < 0) return false;
    if (sum == 0) return true;

    for (var num : nums) {
      var remainder = sum - num;
      if (brute(remainder, nums)) {
        return true;
      }
    }

    return false;
  }

  private static boolean memoized(long sum, int[] nums, Map<Long, Boolean> memo) {
    if (Objects.isNull(memo)) {
      memo = new HashMap<>();
    }
    if (memo.containsKey(sum)) return memo.get(sum);
    if (sum < 0) return false;
    if (sum == 0) return true;

    for (var num : nums) {
      var remainder = sum - num;
      boolean memoized = memoized(remainder, nums, memo);
      if (memoized) {
        memo.put(sum, true);
        return true;
      }
    }
    memo.put(sum, false);
    return false;
  }

  public static boolean memoized(long sum, int[] nums) {
    return memoized(sum, nums, new HashMap<>());
  }
}
