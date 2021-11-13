package mx.com.geekflu.streams;

public class Main implements InterfaceA, InterfaceB{


  @Override
  public void printSomething() {
    InterfaceA.super.printSomething();
    InterfaceB.super.printSomething();
  }

  public static void main(String[] args) {
    Main m = new Main();
    m.printSomething();
  }
}
