package mx.com.geekflu.algo.prep.data.bit.manipulation;

public class BitManipulation {

  public int longestConsecutiveOnesOfANumber(int number) {
    int counter = 0;
    while (number > 0) {
      number = number & (number << 1);
      counter++;
    }
    return counter;
  }

}
