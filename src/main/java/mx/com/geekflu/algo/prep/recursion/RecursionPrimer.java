package mx.com.geekflu.algo.prep.recursion;

import java.util.HashMap;
import java.util.Map;

public class RecursionPrimer {

  private static Map<Long, Long> FIBS = new HashMap<>();

  public static long factorial(long n) {
    if (n == 1) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }
  }

  public static long square(long n) {
    if (n == 0) {
      return 0;
    } else {
      return square(n - 1) + (2 * n) - 1;
    }
  }

  public static long sumAll(long num) {
    if (num == 1) {
      return num;
    } else {
      return num + sumAll(num - 1);
    }
  }

  public static long fibonacci(long num) {

    if(num <= 1) {
      return num;
    }else {
      if(FIBS.containsKey(num)) {
        return FIBS.get(num);
      }

      long result = fibonacci(num - 1) + fibonacci(num - 2);
      FIBS.put(num, result);

      return result;
    }
  }

  public static long pow(long base, long exponenet) {
    if (exponenet == 0) {
      return 1;
    }else {
      return base * pow(base, exponenet - 1);
    }
  }

  public static String reverse(String myString) {
    if (myString.isEmpty()) {
      return myString;
    }else {
      return reverse(myString.substring(1)) + myString.charAt(0);
     }
  }

  public static String removeDuplicates(String text, boolean reverse) {
    if (text.length() == 1) {
      return text;
    }

    if (text.substring(0,1).equals(text.substring(1,2))) {
      return removeDuplicates(text.substring(1), reverse);
    } else {
      if(reverse) {
        return removeDuplicates(text.substring(1), reverse) + text.substring(0, 1);
      }else{
        return text.substring(0, 1) + removeDuplicates(text.substring(1), reverse);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(RecursionPrimer.factorial(20));
    System.out.println("Sum all 100: " +  RecursionPrimer.sumAll(10000));
    int i = 0;
    long start = System.currentTimeMillis();
    while (i < 46) {
      System.out.print(fibonacci(i) + " ");
      i++;
    }
    System.out.println("Time to execute Fibonacci (ms): " + (System.currentTimeMillis() - start));
    System.out.println("2^5 = " + RecursionPrimer.pow(2, 5));
    System.out.println("Reverse a String = " + RecursionPrimer.reverse("abcd"));
    System.out.println("Remove duplicates = " + RecursionPrimer.removeDuplicates("Heelloo WWorld", true));
    System.out.println("Remove duplicates = " + RecursionPrimer.removeDuplicates("Heelloo WWorld", false));
  }

}
