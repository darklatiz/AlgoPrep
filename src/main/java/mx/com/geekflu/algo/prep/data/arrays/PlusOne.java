package mx.com.geekflu.algo.prep.data.arrays;

public class PlusOne {

  public int[] plusOne(int[] digits) {
    int last = digits.length - 1;
    if (digits[last] < 9) {
      digits[last] += 1;
    } else {
      for (int sweeper = last; sweeper >= 0 && digits[sweeper] == 9; sweeper--) {
        if (digits[sweeper] == 9) {
          digits[sweeper] = 0;
        }
        if (sweeper - 1 >= 0 && digits[sweeper - 1] < 9) {
          digits[sweeper - 1] += 1;
        }
      }
    }
    return digits;
  }

}
