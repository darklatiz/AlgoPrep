package mx.com.geekflu.streams;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Main implements InterfaceA, InterfaceB{


  @Override
  public void printSomething() {
    InterfaceA.super.printSomething();
    InterfaceB.super.printSomething();
  }

  public static void main(String[] args) {
    Main m = new Main();
    m.printSomething();

    Random random = new Random();
    IntSupplier intSupplier = () -> random.nextInt(99);

    List<Person> persons = new ArrayList<>();
    persons.add(new Person("John" , intSupplier.getAsInt() , "USA"));
    persons.add(new Person("Carl" , intSupplier.getAsInt() , "Australia"));
    persons.add(new Person("Amit" , intSupplier.getAsInt() , "India"));
    persons.add(new Person("Vikram" , intSupplier.getAsInt() , "Bhutan"));
    persons.add(new Person("Kane" , intSupplier.getAsInt(), "Brazil"));

    PersonService.getPersons(persons).forEach(person -> log.info("{}", person));

    var thePerson = new Person("John" , intSupplier.getAsInt() , "USA");
    var goku = new Person("Goku" , intSupplier.getAsInt() , "USA");


    log.info("{} is eligible for voting: {}",thePerson, PersonService.isPersonEligibleForVoting(() -> thePerson, p -> p.getAge() > 18));
    log.info("{} is eligible for membership: {}",goku, PersonService.isPersonEligibleForMembership(() -> goku, p -> p.getAge() > 18 && p.getAge() < 60));


    List<List<String>> list = new ArrayList<>();
    list.add(Arrays.asList("a","b","c"));
    list.add(Arrays.asList("d","e","f"));
    list.add(Arrays.asList("g","h","i"));
    list.add(Arrays.asList("j","k","l"));
    //Created a stream from the list.
    list.stream()
    // Flattened the stream.
      .flatMap(Collection::stream)
      .filter(s -> s.equals("a"))
      .forEach(s -> log.info("{}", s));


    List<Person> personList = new ArrayList<>();
    personList.add(new Person("Dave", 23,"India", 15034.0));
    personList.add(new Person("Joe", 18,"USA", 25500.23));
    personList.add(new Person("Ryan", 54,"Canada", 123.67));
    personList.add(new Person("Iyan", 5,"India", 6592.99));
    personList.add(new Person("Ray", 63,"China", 1235678.87));

    boolean anyCanadian = personList.stream()
      .anyMatch(p -> p.getCountry().equals("Canada"));

    log.info("Is there any resident of Canada: {}", anyCanadian);

    Optional<Double> totalSalary = personList.stream()
      .map(Person::getSalary)  //We are converting the Stream of Employees to Stream of salaries.
      .reduce(Double::sum);

    totalSalary.ifPresent(aFloat -> log.info("The total salary is\t\t {}", aFloat));

    log.info("Total salary using sum:\t {}", personList.stream()
      .mapToDouble(Person::getSalary)
      .sum());

    LinkedList<String> empName = personList.stream()
      .map(Person::getName)
      .collect(Collectors.toCollection(LinkedList::new));

    log.info("Linked List: {}", empName);

    // The employees are grouped by country using the groupingBy() method.
    Map<String,List<Person>> employeeMap = personList.stream()
      .collect(Collectors.groupingBy(Person::getCountry));

    log.info("The Map: {}", employeeMap);


    List<String> fruits = new ArrayList<>();
    fruits.add("guava");
    fruits.add(null);
    fruits.add("apple");
    fruits.add("banana");

    // Sorting the List keeping nulls first.
    Collections.sort(fruits, Comparator.nullsFirst(Comparator.naturalOrder()));
    fruits.forEach(log::info);
    log.info("*************************");
    Collections.sort(fruits, Comparator.nullsLast(Comparator.naturalOrder()));
    fruits.forEach(log::info);
  }
}
