package mx.com.geekflu.algo.prep.dynamic.programming;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class Fibonacci {

  private Fibonacci() {}

  public static int brute(long number) {
    if (number < 0) {
      throw new RuntimeException("Number cannot be less than 0");
    }

    if (number == 0) {
      return 0;
    }

    if (number == 1) {
      return 1;
    }

    return brute(number - 1) + brute(number - 2);
  }

  public static long memoization(long number, Map<Long, Long> memo) {
    if (number < 0) {
      throw new RuntimeException("Number cannot be less than 0");
    }

    if (Objects.isNull(memo)) {
      memo = new HashMap<>();
    }

    if (number == 0) {
      return 0;
    }

    if (number == 1) {
      return 1;
    }

    if (memo.containsKey(number)) {
      return memo.get(number);
    }

    long result = memoization(number - 1, memo) + memoization(number - 2, memo);
    memo.put(number, result);
    return result;

  }

}
