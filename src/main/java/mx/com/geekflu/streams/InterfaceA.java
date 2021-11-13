package mx.com.geekflu.streams;

public interface InterfaceA {
  default void printSomething(){
    System.out.println("Hola from InterfaceA");
  }
}
