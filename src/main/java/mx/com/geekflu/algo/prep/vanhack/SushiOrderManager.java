package mx.com.geekflu.algo.prep.vanhack;

import java.util.*;


public class SushiOrderManager {
  private int currentSeat;
  private int totalSeats;
  private ArrayList<Queue<SushiItem>> seats;
  private Queue<List<SushiOrder>> orders;
  private CurrentOrder currentOrder;

  public SushiOrderManager() {
    currentSeat = 0;
    totalSeats = 16;
    seats = new ArrayList<>();
    orders = new LinkedList<>();
    currentOrder = new CurrentOrder(0);

    for (int i = 0; i < totalSeats; i++) {
      seats.add(new LinkedList<SushiItem>());
    }
  }

  public void addOrder(ArrayList<SushiOrder> request) {
    orders.offer(request);
  }

  private void createNextOrder() {
    List<SushiOrder> nextOrder = orders.poll();
    if(nextOrder != null) {
      this.currentOrder = new CurrentOrder(0);
      for (SushiOrder order : nextOrder) {
        this.currentOrder.addSushiQtyToOrder(order.getMenuItemIds().size());
        this.currentOrder.getOrderSeats().add(order.getSeatId());
        for (String roll : order.getMenuItemIds()) {
          seats.get(order.getSeatId() - 1).offer(
            new SushiItem(order.getSeatId(), roll)
          );
        }
      }
      this.currentOrder.sortSeats();
    }
  }

  public SushiItem nextItem() {
    if(!this.currentOrder.isOrderInProcess()) {
      createNextOrder();
    }

    int start = currentSeat;

    do {
      SushiItem item = seats.get(currentSeat).poll();
      currentSeat = ++currentSeat % totalSeats;

      if (item != null) {
        this.currentOrder.decreaseSushiServed();
        return item;
      }
    } while (currentSeat != start);

    return null;
  }

  public SushiItem nextItem01() {
    if(!this.currentOrder.isOrderInProcess()) {
      createNextOrder();
    }

    int start = currentSeat;

    do {
      SushiItem item = seats.get(currentSeat).poll();
      currentSeat = ++currentSeat % totalSeats;

      if (item != null) {
        this.currentOrder.decreaseSushiServed();
        return item;
      }
    } while (currentSeat != start);

    return null;
  }
}

class CurrentOrder {
  private int orderSize;
  private int elementsServed;
  private List<Integer> orderSeats;

  public CurrentOrder(int orderSize) {
    this.orderSize = orderSize;
    this.orderSeats = new ArrayList<>();
  }

  public boolean isOrderInProcess() {
    return this.orderSize > 0 && this.elementsServed  >= 0 && this.elementsServed <= this.orderSize;
  }

  public void decreaseSushiServed() {
    this.elementsServed++;
  }

  public void addSushiQtyToOrder(int size) {
    this.orderSize += size;
  }

  public List<Integer> getOrderSeats() {
    return this.orderSeats;
  }

  public void sortSeats(){
    Collections.sort(this.orderSeats);
  }

}