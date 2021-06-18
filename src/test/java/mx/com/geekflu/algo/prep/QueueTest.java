package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.queue.Queue;
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
}
