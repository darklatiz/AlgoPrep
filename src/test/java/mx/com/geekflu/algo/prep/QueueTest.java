package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.queue.Queue;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;


@Slf4j
public class QueueTest {

  @Test
  public void test_queue_creation() {
    Queue<String> queue = new Queue<>();
    Assert.assertNotNull(queue);
    Assert.assertTrue(queue.isEmpty());
    queue.print();
  }

  @Test
  public void test_push_and_pop() {
    Queue<String> queue = new Queue<>();
    String first = RandomStringUtils.randomAlphabetic(5);
    queue.offer(first);

    log.info("Starting offering to QUEUE");
    for (var i = 0; i < 10_000_000; i++) {
      queue.offer(RandomStringUtils.randomAlphabetic(5));
    }
    log.info("Finished offering to QUEUE");

    String last = RandomStringUtils.randomAlphabetic(5);
    queue.offer(last);

    Assert.assertEquals(first, queue.poll());

    log.info("Starting polling from QUEUE, queue size = {}, front value = {}", queue.size(), queue.peek());
    while (queue.size() != 1) {
      queue.poll();
    }
    log.info("Finished polling from QUEUE, queue size = {}, front value = {}", queue.size(), queue.peek());

    Assert.assertFalse(queue.isEmpty());
    Assert.assertEquals(1, queue.size());
    Assert.assertEquals(last, queue.poll());

    Assert.assertTrue(queue.isEmpty());
  }
}
