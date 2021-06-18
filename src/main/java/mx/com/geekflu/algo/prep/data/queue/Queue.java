package mx.com.geekflu.algo.prep.data.queue;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.ifc.Printable;
import mx.com.geekflu.algo.prep.data.core.ifc.Queueable;
import mx.com.geekflu.algo.prep.data.linked.list.LinkedList;

import java.util.Objects;

@Slf4j
public class Queue<T> implements Queueable<T>, Printable {

  private LinkedList<T> orderQueue;

  public Queue() {
    this.orderQueue = new LinkedList<>();
  }

  @Override
  public void print() {
    var stringBuilder = new StringBuilder();
    if (isEmpty()) {
      stringBuilder.append("Queue |Empty|");
      log.info(stringBuilder.toString());
      return;
    }
    stringBuilder.append("Front |");
    for (var i = 0; i < this.orderQueue.size(); i++) {
      var cNode = this.orderQueue.moveTo(i);
      stringBuilder.append(cNode.getItem());
      stringBuilder.append(" | ");
    }
    log.info(stringBuilder.toString());
  }

  @Override
  public boolean offer(T data) {
    return this.orderQueue.append(data);
  }

  @Override
  public T peek() {
    var cNode = this.orderQueue.moveTo(0);
    return Objects.nonNull(cNode) ? cNode.getItem() : null;
  }

  @Override
  public T poll() {
    return this.orderQueue.getFirst();
  }

  @Override
  public boolean isEmpty() {
    return this.orderQueue.isEmpty();
  }

}
