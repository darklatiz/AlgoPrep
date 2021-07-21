package mx.com.geekflu.algo.prep.dynamic.programming;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class Fibonacci {

  private static Map<Long, Long> memo;

  public static int brute(long number) {
    if (number == 0) {
      return 0;
    }

    if (number == 1) {
      return 1;
    }

    return brute(number -1 ) + brute(number - 2);
  }

  public static long memoization(long number) {
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

    long result = memoization(number - 1) + memoization(number - 2);
    memo.put(number, result);

    return result;

  }

}
