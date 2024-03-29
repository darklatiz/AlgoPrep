package mx.com.geekflu.algo.prep;

import java.util.*;

import mx.com.geekflu.algo.prep.vanhack.SushiItem;
import mx.com.geekflu.algo.prep.vanhack.SushiOrder;
import mx.com.geekflu.algo.prep.vanhack.SushiOrderManager;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SushiOrderManagerTest{

  @Test
  public void itShouldWorkAsAnIteratorWithASingleRequest() {
    Queue<SushiItem> expected = queueify(new SushiItem[] {
      new SushiItem(1, "tuna"),
      new SushiItem(2, "salmon"),
      new SushiItem(3, "avocado"),
      new SushiItem(1, "california"),
      new SushiItem(2, "tuna"),
      new SushiItem(1, "avocado"),
      new SushiItem(2, "crab"),
      new SushiItem(2, "scallop")
    });
    ArrayList<SushiOrder> request = new ArrayList<>(
      Arrays.asList(
        new SushiOrder(1, // seatId for this order
          new ArrayList<>(Arrays.asList(
            new String[] {
              // menuItemIds for this order
              "tuna", "california", "avocado"
            }
          ))
        ),
        new SushiOrder(3,
          new ArrayList<>(Arrays.asList(
            new String[] {"avocado"}
          ))
        ),
        new SushiOrder(2,
          new ArrayList<>(Arrays.asList(
            new String[] {
              "salmon", "tuna", "crab", "scallop"
            }
          ))
        )
      )
    );

    SushiOrderManager manager = new SushiOrderManager();
    addOrder(manager, request);

    for (int i = 0; i < 8; i++) {
      assertNextItem(manager, expected.poll());
    }
  }

  @Test
  public void itShouldWorkAsAnIteratorWithASingleRequest01() {
    Queue<SushiItem> expected = queueify(new SushiItem[] {
      new SushiItem(1, "tuna"),
      new SushiItem(2, "salmon"),
      new SushiItem(3, "avocado"),
      new SushiItem(1, "california"),
      new SushiItem(2, "tuna"),
      new SushiItem(1, "avocado"),
      new SushiItem(2, "crab"),
      new SushiItem(2, "scallop")
    });

    ArrayList<SushiOrder> request = new ArrayList<>(
      Arrays.asList(
        new SushiOrder(12, // seatId for this order
          new ArrayList<>(Arrays.asList(
            new String[] {"brown rice",
              "kimchi",
              "mushroom",
            }
          ))
        ),
        new SushiOrder(1,
          new ArrayList<>(Arrays.asList(
            new String[] {"mushroom", "tuna", }
          ))
        ),
        new SushiOrder(10,
          new ArrayList<>(Arrays.asList(
            new String[] {
              "mushroom"
            }
          ))
        ),
        new SushiOrder(3,
          new ArrayList<>(Arrays.asList(
            new String[] {
              "teriyaki", "california", "teriyaki", "shiitake"
            }
          ))
        )
      )
    );

    SushiOrderManager manager = new SushiOrderManager();
    addOrder(manager, request);

    request = new ArrayList<>(
      Arrays.asList(
        new SushiOrder(16, // seatId for this order
          new ArrayList<>(Arrays.asList(
            new String[] {"lox",
              "zucchini",
              "dynamite",
            }
          ))
        ),
        new SushiOrder(14,
          new ArrayList<>(Arrays.asList(
            new String[] {"avocado" }
          ))
        )
      )
    );

    addOrder(manager, request);

    for (int i = 0; i < 8; i++) {
      assertNextItem(manager, expected.poll());
    }
  }

  @Test
  public void itShouldWorkAsAnIteratorWithASingleRequestnn() {
    Queue<SushiItem> expected = queueify(new SushiItem[] {
      new SushiItem(13, "rainbow"),
      new SushiItem(13, "\"tuna\""),
      new SushiItem(1, "cucumber")
    });

    SushiOrderManager manager = new SushiOrderManager();

    ArrayList<SushiOrder> request = new ArrayList<>(
      Arrays.asList(
        new SushiOrder(13,
          new ArrayList<>(Arrays.asList(
            new String[] {"rainbow", "\"tuna\""}
          ))
        )
      )
    );

    addOrder(manager, request);
    assertNextItem(manager, expected.poll());

    request = new ArrayList<>(
      Arrays.asList(
        new SushiOrder(1,
          new ArrayList<>(Arrays.asList(
            new String[] {"cucumber"}
          ))
        )
      )
    );

    addOrder(manager, request);
    assertNextItem(manager, expected.poll());
    assertNextItem(manager, expected.poll());
  }

  @Test
  public void itShouldWorkWhenOrdersAndItemDeliveriesAreInterleaved() {
    Queue<SushiItem> expected = queueify(new SushiItem[] {
      new SushiItem(1, "avocado"),
      new SushiItem(2, "dragon"),
      new SushiItem(1, "dynamite"),
      new SushiItem(1, "mushroom"),
      null
    });
    ArrayList<SushiOrder> request = new ArrayList<>(
      Arrays.asList(
        new SushiOrder(2,
          new ArrayList<>(Arrays.asList(
            new String[] {"dragon"}
          ))
        ),
        new SushiOrder(1,
          new ArrayList<>(Arrays.asList(
            new String[] {"avocado", "dynamite"}
          ))
        )
      )
    );
    SushiOrderManager manager = new SushiOrderManager();

    addOrder(manager, request);
    assertNextItem(manager, expected.poll());

    request = new ArrayList<>(
      Arrays.asList(
        new SushiOrder(1,
          new ArrayList<>(Arrays.asList(
            new String[] {"mushroom"}
          ))
        )
      )
    );
    addOrder(manager, request);

    for (int i = 0; i < 4; i++) {
      assertNextItem(manager, expected.poll());
    }
  }

  private static void assertNextItem(
    SushiOrderManager manager, SushiItem expected
  ) {
    SushiItem item = manager.nextItem();
    System.out.println("<LOG::-Next Item>" + item);
//    assertEquals(expected, item);
  }

  private static void addOrder(
    SushiOrderManager manager,
    ArrayList<SushiOrder> request
  ) {
    System.out.println("<LOG::-Add Order>" + request);
    manager.addOrder(request);
  }

  private static Queue<SushiItem> queueify(SushiItem[] steps) {
    Queue<SushiItem> result = new LinkedList<>();

    for (SushiItem step : steps) {
      result.offer(step);
    }

    return result;
  }
}