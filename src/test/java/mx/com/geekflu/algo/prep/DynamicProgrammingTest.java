package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.dynamic.programming.Fibonacci;
import mx.com.geekflu.algo.prep.dynamic.programming.GridTraveler;
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
    log.info("fib({}) = {}", 50, Fibonacci.memoization(50));
    log.info("fib({}) = {}", 60, Fibonacci.memoization(60));
    log.info("fib({}) = {}", 90, Fibonacci.memoization(90));
    Assert.assertEquals(0, Fibonacci.memoization(0));
  }

  @Test
  public void test_grid_traveler_brute_force() {
    Assert.assertEquals(1, GridTraveler.brute(1, 1));
    Assert.assertEquals(3, GridTraveler.brute(2, 3));
    Assert.assertEquals(6, GridTraveler.brute(3, 3));
    Assert.assertEquals(40116600L, GridTraveler.brute(15, 15));
  }

  @Test
  public void test_grid_traveler_memoized() {
    // brute forde approach takes 22 seconds
//    Assert.assertEquals(2333606220L, GridTraveler.brute(18, 18));
    Assert.assertEquals(2333606220L, GridTraveler.memoized(18, 18));

  }

}
