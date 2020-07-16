package mx.com.geekflu.algo.prep.data.arrays;

public class PlusOne {

  public int[] plusOne(int[] digits) {
    int last = digits.length - 1;
    if (digits[last] < 9) {
      digits[last] += 1;
    }
    return digits;
  }

}
