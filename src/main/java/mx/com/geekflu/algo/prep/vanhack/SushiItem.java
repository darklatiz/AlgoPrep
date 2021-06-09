package mx.com.geekflu.algo.prep.vanhack;

import java.util.Objects;

public class SushiItem {
  private int seatId;
  private String menuItemId;

  public SushiItem(int seatId, String menuItemId) {
    this.menuItemId = menuItemId;
    this.seatId = seatId;
  }

  public int getSeatId() {
    return this.seatId;
  }
  public String getMenuItemId() {
    return this.menuItemId;
  }

  @Override
  public String toString() {
    return "SushiItem{" +
      "seatId=" + seatId +
      ", menuItemId='" + menuItemId + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SushiItem sushiItem = (SushiItem) o;
    return seatId == sushiItem.seatId && Objects.equals(menuItemId, sushiItem.menuItemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seatId, menuItemId);
  }
}