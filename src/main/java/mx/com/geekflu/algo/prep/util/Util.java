package mx.com.geekflu.algo.prep.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Util {
  private static final Random random = new Random();

  public static Integer[] generateArray(int size) {
    Integer[] arr = new Integer[size];
    for (int i = 0; i < size; i++) {
      arr[i] = Util.random.nextInt(size * 10);
    }
    return arr;
  }

  public static int[] generatePrimitiveArray(int size) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = Util.random.nextInt(size * 10);
    }
    return arr;
  }

  public static Integer[] generateArray(int size, boolean ascOrder) {
    Integer[] arr = generateArray(size);
    if (ascOrder) {
      Arrays.sort(arr);
    }else {
      Arrays.sort(arr, Collections.reverseOrder());
    }
    return arr;
  }

  public static int getRandomInt(int bound) {
    return Util.random.nextInt(bound);
  }

}
