package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.stack.Stack;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

@Slf4j
public class StackTest {

  @Test
  public void test_stack_creation() {
    Stack<Integer> stack = new Stack<>();
    Assert.assertNotNull(stack);
    Assert.assertTrue(stack.isEmpty());
    Assert.assertNull(stack.peek());
    Assert.assertNull(stack.pop());
  }

  @Test
  public void test_stack_push_and_pop() {
    Stack<String> stack = new Stack<>();
    stack.push("c");
    stack.push("b");
    stack.push("a");
    Assert.assertFalse(stack.isEmpty());
    Assert.assertEquals("a", stack.peek());
    stack.print();

    Assert.assertEquals("a", stack.pop());
    stack.print();

    Assert.assertEquals("b", stack.pop());
    stack.print();

    stack.push("Z");
    stack.print();

    Assert.assertEquals("Z", stack.pop());
    stack.print();

    Assert.assertEquals("c", stack.pop());
    stack.print();

    Assert.assertTrue(stack.isEmpty());

  }

  @Test
  public void test_load() {
    Stack<Integer> stack = new Stack<>();
    Random random = new Random();

    log.info("Pushing Starting...");
    for (var i = 0; i < 40_000_000 ; i++) {
      stack.push(random.nextInt());
    }
    log.info("Pushing Finished...");
    Assert.assertNotNull(stack);
    Assert.assertFalse(stack.isEmpty());

    log.info("Poping Started...");
    while (!stack.isEmpty()) {
      Integer integer = stack.pop();
      Assert.assertNotNull(integer);
//      log.info("Popped value = {}", integer);
    }
    log.info("Poping Finished...");
    Assert.assertTrue(stack.isEmpty());
  }
}
