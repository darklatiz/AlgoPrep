package mx.com.geekflu.algo.prep.data.april.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Week1 {


  public boolean isHappy(int n) {
    Map<Integer, Integer> seen = new HashMap<>();
    int number = 0;
    while (n > 1 && !seen.containsKey(n)){
      seen.put(n, n);
      n = pdi(n, 10);
    }
    return n == 1;
  }

  private int pdi(int number, int base) {
    int total  = 0;
    while(number > 0){
      total = (int) (total + Math.pow(number % base, 2));
      number = (int) Math.floor(number / base);
    }
    return total;
  }

  public int singleNumber(int[] nums) {
    if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
    Arrays.sort(nums);
    int number = Integer.MIN_VALUE;
    int twicwCounter = 0;
    for (int i = 0; i < nums.length; i = i + 2){
      if(i < nums.length - 1 && nums[i] != nums[i + 1]){
        number = nums[i];
        break;
      }
    }
    if(number == Integer.MIN_VALUE) {
      number = nums[nums.length - 1];
    }
    return number;
  }

  public int singleNumberFastest(int[] A){
  int num = 0;
    for(int zebra = 0; zebra < A.length; zebra++){
      num = num ^ A[zebra];
    }
    return num;
  }

  private void executeSingleNumber() {
    int[] A = {2, 2, 3, 3, 5, 4, 4};
    int[] B = {4,1,2,1,2};
    int[] C = {1};
    int[] D = {2, 2, 1};
    System.out.println("executeSingleNumber..........................");
    System.out.println(singleNumber(A));
    System.out.println(singleNumber(B));
    System.out.println(singleNumber(C));
    System.out.println(singleNumber(D));

    System.out.println("executeSingleNumber Fastest..........................");
    System.out.println(singleNumberFastest(A));
    System.out.println(singleNumberFastest(B));
    System.out.println(singleNumberFastest(C));
    System.out.println(singleNumberFastest(D));
  }

  public static void main(String[] args) {
    Week1 w = new Week1();
    w.executeSingleNumber();
    w.executeHappyNumber();
  }

  private void executeHappyNumber() {

   System.out.println("executeHappyNumber......");
   System.out.println(isHappy(19));

  }
}
