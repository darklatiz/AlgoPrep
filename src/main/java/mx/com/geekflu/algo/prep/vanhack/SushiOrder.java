package mx.com.geekflu.algo.prep.vanhack;

import java.util.List;

public class SushiOrder {
  private int seatId;
  private List<String> menuItemIds;
  public SushiOrder(int seatId, List<String> menuItemIds) {
    this.seatId = seatId;
    this.menuItemIds = menuItemIds;
  }
  public int getSeatId() {
    return this.seatId;
  }
  public List<String> getMenuItemIds() {
    return this.menuItemIds;
  }

  @Override
  public String toString() {
    return "SushiOrder{" +
      "seatId=" + seatId +
      ", menuItemIds=" + menuItemIds +
      '}';
  }
}