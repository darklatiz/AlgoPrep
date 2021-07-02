package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.stack.MaxStack;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class MaxStackTest {

  @Test
  public void tes_max_stack() {
    MaxStack<Integer> maxStack = new MaxStack<>();
    Assert.assertNotNull(maxStack);
    var size = 1000_000;

    for (var i = 0; i < size; i++ ) {
      int anInt = RandomUtils.nextInt(0, (int) (size * 1.4));
      maxStack.push(anInt);
    }

    while (!maxStack.isEmpty()){
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

}
