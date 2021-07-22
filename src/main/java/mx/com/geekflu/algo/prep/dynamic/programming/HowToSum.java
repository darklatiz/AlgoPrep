package mx.com.geekflu.algo.prep.dynamic.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HowToSum {

  private HowToSum() {}

  public static List<Integer> brute(int targetSum, List<Integer> numbers) {
    if (targetSum < 0) return null;
    if (targetSum == 0) return new ArrayList<>();

    for (var num : numbers) {
      var remainder = targetSum - num;
      var result = brute(remainder, numbers);
      if (Objects.nonNull(result)) {
        result.add(num);
        return result;
      }
    }
    return null;
  }

  public static List<Integer> memoized(int targetSum, List<Integer> numbers, Map<Integer, List<Integer>> memo) {
    if (Objects.isNull(memo)) {
      memo = new HashMap<>();
    }

    if (memo.containsKey(targetSum)) return memo.get(targetSum);
    if (targetSum < 0) return null;
    if (targetSum == 0) return new ArrayList<>();

    //branching out for
    for (var num : numbers) {
      var remainder = targetSum - num;
      var remainderResult = memoized(remainder, numbers, memo);
      if (Objects.nonNull(remainderResult)) {
        remainderResult.add(num);
        memo.put(num, remainderResult);
        return memo.get(num);
      }
    }

    memo.put(targetSum, null);
    return null;

  }

  public static List<Integer> memoized(int targetSum, List<Integer> numbers) {
    return memoized(targetSum, numbers, new HashMap<>());
  }

}
