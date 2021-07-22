package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.dynamic.programming.CanSum;
import mx.com.geekflu.algo.prep.dynamic.programming.Fibonacci;
import mx.com.geekflu.algo.prep.dynamic.programming.GridTraveler;
import mx.com.geekflu.algo.prep.dynamic.programming.HowToSum;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
    log.info("fib({}) = {}", 60, Fibonacci.memoization(60 ));
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
    Assert.assertEquals(2333606220L, GridTraveler.memoized(18, 18));

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
    Assert.assertFalse(CanSum.memoized(3000, new int[]{7, 14})); // <-------------- not very performant takes too much time to execute using brute force approach
    Assert.assertFalse(CanSum.memoized(30000, new int[]{7, 14})); // <-------------- not very performant takes too much time to execute using brute force approach
  }

  @Test
  public void tes_how_to_sum_brute() {
    List<Integer> numbers = List.of(2, 3);
    log.info("Res = {}", HowToSum.brute(7, numbers));
    Assert.assertEquals("[3, 2, 2]", HowToSum.brute(7, numbers).toString());

    log.info("Res = {}", HowToSum.brute(7, List.of(5, 3, 4, 7)));
    log.info("Res = {}", HowToSum.brute(7, List.of(2, 4)));
    log.info("Res = {}", HowToSum.brute(8, List.of(2, 3, 5)));

  }

  @Test
  public void tes_how_to_sum_memoized() {
//    log.info("Res = {}", HowToSum.brute(300, List.of(7, 14))); // 6 seg
    log.info("Res = {}", HowToSum.memoized(300, List.of(7, 14)));

    Assert.assertNull(HowToSum.memoized(300, List.of(7, 14)));

  }

}
