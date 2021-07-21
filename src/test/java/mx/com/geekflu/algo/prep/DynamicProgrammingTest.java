package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.dynamic.programming.CanSum;
import mx.com.geekflu.algo.prep.dynamic.programming.Fibonacci;
import mx.com.geekflu.algo.prep.dynamic.programming.GridTraveler;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

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
    var memo = new HashMap<Long, Long>();
    log.info("fib({}) = {}", 50, Fibonacci.memoization(50, memo));
    log.info("fib({}) = {}", 60, Fibonacci.memoization(60, null));
    log.info("fib({}) = {}", 90, Fibonacci.memoization(90, memo));
    Assert.assertEquals(0, Fibonacci.memoization(0, null));
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
    var memo = new HashMap<String, Long>();
    Assert.assertEquals(2333606220L, GridTraveler.memoized(18, 18, memo));

  }

  @Test
  public void test_can_sum_brute_fore() {
    Assert.assertTrue(CanSum.brute(7, new int[]{2, 3}));
    Assert.assertTrue(CanSum.brute(7, new int[]{5, 3, 4, 7}));
    Assert.assertTrue(CanSum.brute(8, new int[]{2, 3, 5}));
    Assert.assertFalse(CanSum.brute(7, new int[]{2, 4}));
  }

  @Test
  public void test_can_sum_memoized() {
    var memo1 = new HashMap<Long, Boolean>();
    Assert.assertFalse(CanSum.memoized(3000, new int[]{7, 14}, memo1)); // <-------------- not very performant takes too much time to execute

    Assert.assertFalse(CanSum.memoized(30000, new int[]{7, 14}, null)); // <-------------- not very performant takes too much time to execute
  }

}
