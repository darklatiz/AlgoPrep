package mx.com.geekflu.streams;

import mx.com.geekflu.model.Person;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PersonService {

  public static List<Person> getPersons(List<Person> personList){
    Collections.sort(personList, (p1, p2) -> p1.getName().compareTo(p2.getName()));
    return personList;
  }

  public static boolean isPersonEligibleForVoting(Supplier<Person> personSupplier, Predicate<Person> predicate){
    return predicate.test(personSupplier.get());
  }

  public static boolean isPersonEligibleForMembership(Supplier<Person> personSupplier, Predicate<Person> predicate){
    return predicate.test(personSupplier.get());
  }

}
