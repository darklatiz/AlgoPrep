package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.stack.MaxStack;
import mx.com.geekflu.algo.prep.data.stack.MinStack;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class MaxMinStackTest {

  @Test
  public void tes_max_stack() {
    MaxStack<Integer> maxStack = new MaxStack<>();
    Assert.assertNotNull(maxStack);
    var size = 1000_000;

    for (var i = 0; i < size; i++) {
      int anInt = RandomUtils.nextInt(0, (int) (size * 1.4));
      maxStack.push(anInt);
    }

    while (!maxStack.isEmpty()) {
      maxStack.pop();
      if (maxStack.size() <= 15) {
        log.info("The max = {}", maxStack.getMax());
        maxStack.print();
        log.info("\n");
      }
    }

    Assert.assertNull(maxStack.getMax());
    Assert.assertNull(maxStack.pop());


  }

  @Test
  public void test_min_stack() {
    MinStack<Integer> minStack = new MinStack<>();
    int size = 10_000_000;
    Assert.assertNotNull(minStack);
    minStack.print();

    for (var i = 0; i < size; i++) {
      int anInt = RandomUtils.nextInt(0, (int) (size * 1.4));
      minStack.push(anInt);
    }

    while (!minStack.isEmpty()) {
      minStack.pop();
      if (minStack.size() <= 15) {
        log.info("The min = {}", minStack.getMin());
        minStack.print();
        log.info("\n");
      }
    }

    Assert.assertNull(minStack.getMin());
    Assert.assertNull(minStack.pop());

  }

}
