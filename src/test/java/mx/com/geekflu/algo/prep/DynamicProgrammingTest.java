package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.dynamic.programming.Fibonacci;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class DynamicProgrammingTest {

  @Test
  public void test_fibonacci_brute_force_approach() {
    Assert.assertEquals(0, Fibonacci.brute(0));
    Assert.assertEquals(1, Fibonacci.brute(1));
    Assert.assertEquals(1, Fibonacci.brute(2));
    Assert.assertEquals(2, Fibonacci.brute(3));
    Assert.assertEquals(3, Fibonacci.brute(4));
    Assert.assertEquals(55, Fibonacci.brute(10));
    Assert.assertEquals(89, Fibonacci.brute(11));
    log.info("result = {}", Fibonacci.brute(30));
  }

  @Test
  public void test_fibonacci_memoize_approach() {
    log.info("result fib({}) = {}", 50, Fibonacci.memoization(50));
    log.info("result fib({}) = {}", 60, Fibonacci.memoization(60));
    Assert.assertEquals(0, Fibonacci.memoization(0));
  }

}
