package mx.com.geekflu.algo.prep.dynamic.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BestSum {

  private BestSum() {}

  public static List<Integer> brute(int targetSum, List<Integer> numbers) {
    if (targetSum == 0) return new ArrayList<>();
    if (targetSum < 0) return null;

    List<Integer> shortestCombination = null;

    for (var num : numbers) {
      int remainder = targetSum - num;
      List<Integer> remainderResult = brute(remainder, numbers);
      if (Objects.nonNull(remainderResult)) {
        remainderResult.add(num);
        if (Objects.isNull(shortestCombination) || remainderResult.size() < shortestCombination.size()) {
          shortestCombination = remainderResult;
        }
      }
    }
    return shortestCombination;
  }

  private static List<Integer> memoized(int targetSum, List<Integer> numbers, Map<Integer, List<Integer>> memo) {
    if (Objects.isNull(memo)) {
      memo = new HashMap<>();
    }
    if (memo.containsKey(targetSum)) return new ArrayList<>(memo.get(targetSum));
    if (targetSum == 0) return new ArrayList<>();
    if (targetSum < 0) return null;

    List<Integer> shortestCombination = null;

    for (var num : numbers) {
      int remainder = targetSum - num;
      List<Integer> remainderResult = memoized(remainder, numbers, memo);
      if (Objects.nonNull(remainderResult)) {
        remainderResult.add(num);
        if (Objects.isNull(shortestCombination) || remainderResult.size() < shortestCombination.size()) {
          shortestCombination = new ArrayList<>(remainderResult);
        }
      }
    }
    memo.put(targetSum, new ArrayList<>(shortestCombination));
    return memo.get(targetSum);

  }

  public static List<Integer> memoized(int targetSum, List<Integer> numbers) {
    Map<Integer, List<Integer>> memo = new HashMap<>();
    List<Integer> result = memoized(targetSum, numbers, memo);
    return result;
  }
}
