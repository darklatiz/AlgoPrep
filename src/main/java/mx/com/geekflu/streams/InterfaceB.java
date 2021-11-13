package mx.com.geekflu.streams;

public interface InterfaceB {

  default void printSomething(){
    System.out.println("Hola from InterfaceB");
  }

}
