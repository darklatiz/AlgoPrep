package mx.com.geekflu.streams;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

@Slf4j
public class StampLockDemo {
  static Map<String, Integer> data = new HashMap<>();
  static StampedLock lock = new StampedLock();

  //Method to read data from the Map. Since we are using tryReadLock(), the thread will not block.
  public static Integer readDataFromMap(String key) {

    long stamp = lock.tryReadLock();
    int result = 0;
    if (stamp != 0L) {
      try {
        result = data.get(key);
      } finally {
        lock.unlockRead(stamp);
      }
    }
    return result;
  }

  //Method to write data to the Map. Since we are using tryWriteLock(), the thread will not block.
  public static void writeDataToMap(String key, Integer value) {
    long stamp = lock.tryWriteLock();
    if (stamp != 0L) {
      try {
        data.put(key, value);
      } finally {
        lock.unlockWrite(stamp);
      }
    }
  }

  public static void main(String[] args) {
    writeDataToMap("ray", 123);
    Integer val = readDataFromMap("ray");
    log.info("{}", val);


    // parse(CharSequence text)
    LocalDate date = LocalDate.parse("2015-02-12");
    System.out.println(date);

    // parse(CharSequence text, DateTimeFormatter formatter)
    date = LocalDate.parse("12/02/2012", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    System.out.println(date);


    // Adding 4 days to the given date.
    LocalDate date01 = LocalDate.parse("2015-02-12").plusDays(4);
    System.out.println(date01);

    // Adding 4 months to the given date.
    date01 = LocalDate.parse("2015-02-12").plus(4, ChronoUnit.MONTHS);
    System.out.println(date01);


    // of(int hour, int minute)
    LocalTime time = LocalTime.of(11, 25);
    System.out.println(time);

    // of(int hour, int minute, int second)
    time = LocalTime.of(11, 25, 03);
    System.out.println(time);

    // of(int hour, int minute, int second, int nanoOfSecond)
    time = LocalTime.of(11, 25, 04, 323);
    System.out.println(time);



    ZonedDateTime zonedDateTime = ZonedDateTime.now();

    System.out.println("Date after adding Year is: " + zonedDateTime.plusYears(1));

    System.out.println("Date after adding Month is: " + zonedDateTime.plusMonths(1));

    System.out.println("Date after adding days is: " + zonedDateTime.plusDays(15));

    System.out.println("Date after adding hours is: " + zonedDateTime.plusHours(15));

    System.out.println("Date after adding minutes is: " + zonedDateTime.plusMinutes(1));

    System.out.println("Date after adding seconds is: " + zonedDateTime.plusSeconds(15));

    System.out.println("Date after adding nanoseconds is: " + zonedDateTime.plusNanos(15));

    System.out.println("Date after subtracting Year is: " + zonedDateTime.minusYears(1));

    System.out.println("Date after subtractng Month is: " + zonedDateTime.minusMonths(1));

    System.out.println("Date after subtracting days is: " + zonedDateTime.minusDays(15));

    System.out.println("Date after subtracting hours is: " + zonedDateTime.minusHours(15));

    System.out.println("Date after subtracting minutes is: " + zonedDateTime.minusMinutes(1));

    System.out.println("Date after subtracting seconds is: " + zonedDateTime.minusSeconds(15));

    System.out.println("Date after subtracting nanoseconds is: " + zonedDateTime.minusNanos(15));

    Period period = Period.between(LocalDate.parse("2020-05-18"), LocalDate.parse("2017-04-17"));
    System.out.println(period);

  }
}
