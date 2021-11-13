package mx.com.geekflu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {

  private String name;
  private int age;
  private String country;
  private double salary;

  public Person(String name, int age, String country) {
    this.name = name;
    this.age = age;
    this.country = country;
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", age=" + age +
      ", country='" + country + '\'' +
      '}';
  }
}
