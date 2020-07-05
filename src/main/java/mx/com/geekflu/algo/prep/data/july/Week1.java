package mx.com.geekflu.algo.prep.data.july;

import java.util.Arrays;

public class Week1 {

  public int singleNumber(int[] nums) {
    if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
    Arrays.sort(nums);
    int twicwCounter = 0;
    for (int i = 0; i < nums.length; i++){
      if(nums[i] == nums[i + 1]){

      }
    }

    return 0;
  }

  private void executeSingleNumber() {
    int[] A = {0, 2, 2, 3, 3, 4, 4};
    System.out.println("executeSingleNumber..........................");
    System.out.println(singleNumber(A));

  }

  public static void main(String[] args) {
    Week1 w = new Week1();
    w.executeSingleNumber();
  }
}
