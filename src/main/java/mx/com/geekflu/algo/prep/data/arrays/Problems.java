package mx.com.geekflu.algo.prep.data.arrays;

import java.util.Arrays;
import java.util.Collection;

public class Problems {

  public int findMaxConsecutiveOnes(int[] nums) {
    if (nums == null || nums.length <= 0) return 0;
    int onecounter = 0;
    int maxCounter = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        onecounter++;
        if (maxCounter < onecounter) {
          maxCounter = onecounter;
        }
      } else {
        onecounter = 0;
      }
    }
    return maxCounter;
  }

  public int findNumbers(int[] nums) {
    int counter = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 10 && nums[i] < 100) counter++;
      else if (nums[i] >= 1000 && nums[i] < 10000) counter++;
      else if (nums[i] == 100000) counter++;
    }
    return counter;
  }

  public int[] sortedSquares(int[] A) {
    for (int i = 0; i < A.length; i++) {
      A[i] = A[i] * A[i];
    }
    Arrays.sort(A);
    return A;
  }

  public int[] sortedSquaresAlternateSolution(int[] A) {
    int negIdx = -1;
    int posIdx = A.length;
    for (int i = 0; i < A.length; i++) {
      if (A[i] < 0) negIdx = i;
      else if (A[i] >= 0) {
        posIdx = i;
        break;
      }
    }
    int[] B = new int[A.length];
    int Bidx = 0;

    while (negIdx >= 0 && posIdx < A.length) {
      int negSquare = A[negIdx] * A[negIdx];
      int posSquare = A[posIdx] * A[posIdx];
      if(negSquare < posSquare){
        B[Bidx++] = negSquare;
        negIdx--;
      }else{
        B[Bidx++] = posSquare;
        posIdx++;
      }
    }

    while (A.length >= 1 && negIdx >= 0){
      B[Bidx++] = A[negIdx] * A[negIdx];
      negIdx--;
    }

    while(A.length >= 1 && posIdx < A.length){
      B[Bidx++] = A[posIdx] * A[posIdx];
      posIdx++;
    }

    return B;
  }

  public static void main(String[] args) {
    Problems p = new Problems();
    p.executeFindMaxConsecutiveOnes();
    p.executeFindNumbers();
    p.executeSortedSquares();
  }

  private void executeSortedSquares() {
    int[] B = {-4, -1, 0, 3, 10};
    int[] B1 = {-234,-123, -100, -33, -11, -4, -1, 1, 3, 10};
    int[] B2 = {-1};
    System.out.println(Arrays.toString(sortedSquares(B)));
    System.out.println(Arrays.toString(sortedSquaresAlternateSolution(B1)));
    System.out.println(Arrays.toString(sortedSquaresAlternateSolution(B2)));
  }

  private void executeFindNumbers() {
    int[] nums = {12, 345, 2, 6, 7896};
    System.out.println("executeFindNumbers: " + findNumbers(nums));
  }

  private void executeFindMaxConsecutiveOnes() {
    int[] nums = {1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1};
    int[] nums1 = {1, 0, 1, 1, 0, 1};
    System.out.println(findMaxConsecutiveOnes(nums));
  }

}
