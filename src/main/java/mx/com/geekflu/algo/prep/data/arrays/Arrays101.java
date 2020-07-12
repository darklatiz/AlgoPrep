package mx.com.geekflu.algo.prep.data.arrays;

import java.util.Arrays;

public class Arrays101 {

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
      if (negSquare < posSquare) {
        B[Bidx++] = negSquare;
        negIdx--;
      } else {
        B[Bidx++] = posSquare;
        posIdx++;
      }
    }

    while (A.length >= 1 && negIdx >= 0) {
      B[Bidx++] = A[negIdx] * A[negIdx];
      negIdx--;
    }

    while (A.length >= 1 && posIdx < A.length) {
      B[Bidx++] = A[posIdx] * A[posIdx];
      posIdx++;
    }

    return B;
  }

  public int removeElement(int[] nums, int val) {
    int counter = 0;
    int endIdx = nums.length - 1;
    for (int zebra = 0; zebra < nums.length; zebra++) {
      if (nums[zebra] == val) {
        int swap = nums[endIdx];
        nums[endIdx] = nums[zebra];
        nums[zebra] = swap;
        endIdx--;
        counter++;
      }
    }
    return counter;
  }

  public int removeElementLeet(int[] nums, int val) {
    int i = 0;
    int n = nums.length;
    while (i < n) {
      if (nums[i] == val) {
        nums[i] = nums[n - 1];
        // reduce array size by one
        n--;
      } else {
        i++;
      }
    }
    return n;
  }

  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0 || nums.length == 1) return;

    int right = 0, left = 0;
    int temp;
    while (right < nums.length) {
      if (nums[right] == 0) {
        ++right;
      } else {
        temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        ++left;
        ++right;
      }
    }
  }

  public static void main(String[] args) {
    Arrays101 p = new Arrays101();
    p.executeFindMaxConsecutiveOnes();
    p.executeFindNumbers();
    p.executeSortedSquares();
    p.executeDuplicateZeros();
    p.executeMergeSortedArrays();
    p.executeRemoveElement();
    p.executeRemoveElementSorted();
    p.executeIfExists();
    p.executeValidMountain();
    p.executeReplaceElements();
    p.executeMoveZeroes();
    p.executeSortArrayByParity();
    p.executeHeightChecker();
  }

  public int heightChecker(int[] heights) {
    int count = 0;
    if (heights == null || heights.length == 0) return count;
    int len = heights.length;
    int[] newArr = new int[heights.length];
    System.arraycopy(heights, 0, newArr, 0, len);
    Arrays.sort(newArr);
    for (int i = 0; i < len; i++) {
      if (newArr[i] != heights[i])
        count++;
    }
    return count;
  }

  private void executeHeightChecker() {
    System.out.println("executeHeightChecker.......");
    int[] A = {1, 1, 4, 2, 1, 3};
    System.out.println(heightChecker(A));
  }

  public int[] sortArrayByParity(int[] A) {
    if (A == null || A.length == 0 || A.length == 1) return A;

    int left = 0, right = 0;
    int temp;

    while (right < A.length) {
      if (A[right] % 2 == 1) {
        right++;
      } else {
        //lets swap
        temp = A[left];
        A[left] = A[right];
        A[right] = temp;
        left++;
        right++;
      }
    }
    return A;
  }

  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  private void executeMoveZeroes() {
    int[] A = {0, 12, 1, 2, 0, 2, 0, 2, 0};
    int[] B = {0, 0, 1};
    System.out.println("executeMoveZeroes....");
    moveZeroes(B);
    System.out.println(Arrays.toString(B));
  }

  private void executeRemoveElementSorted() {
    int[] A = {3, 3, 3, 3, 3, 3, 3, 3, 34};
    System.out.println("executeRemoveElementSorted...");
    removeDuplicates(A);
    System.out.printf("for Array: %s", Arrays.toString(A));
  }

  private void executeRemoveElement() {
    int[] A = {0, 1, 2, 2, 3, 0, 4, 2};
    int[] AA = {0, 1, 2, 2, 3, 0, 4, 2};
    int[] B = {-1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3};
    System.out.println("executeRemoveElement...");
    int deletedCounted = removeElement(A, 2);
    int deletedCountedA = removeElementLeet(AA, 2);
    System.out.printf("Value %d was deleted %d for Array: %s", 2, deletedCounted, Arrays.toString(A));
    System.out.printf("\nValue %d was deleted %d for Array: %s", 2, deletedCountedA, Arrays.toString(AA));

    deletedCounted = removeElement(B, 3);
    System.out.printf("\nValue %d was deleted %d for Array: %s", 3, deletedCounted, Arrays.toString(B));
    System.out.println();
  }

  private void executeMergeSortedArrays() {
    int[] A = {-1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0}; // m = 3
    int[] B = {-1, -1, 0, 0, 1, 2};       // n = 3
    int[] A1 = {-1, -1, 0, 0, 0, 0}; // m = 3
    int[] B1 = {-1, 0};       // n = 3
    System.out.println("executeMergeSortedArrays...");
    merge(A1, A1.length, B1, B1.length);
    merge(A, A.length, B, B.length);
    System.out.println(Arrays.toString(A1));
    System.out.println(Arrays.toString(A));

  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = 0, j = 0; i < nums1.length; i++) {
      if (j < n && nums2[j] <= nums1[i]) {
        for (int k = nums1.length - 1; k > i; k--) {
          nums1[k] = nums1[k - 1];
        }
        nums1[i] = nums2[j];
        j++;
      } else {
        if (nums1[i] == 0 && i >= m && j < n) {
          nums1[i] = nums2[j++];
        }
      }
    }
  }

  private int[] duplicateZeros(int[] B) {
    for (int j = 0; j < B.length; j++) {
      if (B[j] == 0 && (j + 1) < B.length) {
        shift2Right(B, j + 1, 1);
        j = j + 1;
      }
    }
    return B;
  }

  private void shift2Right(int[] A, int fromIdx, int steps) {
    while (steps > 0) {
      for (int i = A.length - 1; i > fromIdx; i--) {
        A[i] = A[i - 1];
      }
      steps--;
      A[fromIdx] = 0;
    }
  }

  public boolean checkIfExist(int[] arr) {
    for (int zebra = 0; zebra < arr.length; zebra++) {
      int m = arr[zebra];
      for (int lion = 0; lion < arr.length; lion++) {
        if (lion != zebra && 2 * arr[lion] == m) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean validMountainArray(int[] A) {
    if (A == null || A.length < 3) {
      return false;
    }
    boolean increasing = false;
    boolean decreasing = false;
    int peak = 0;
    for (int i = 0; i < A.length - 1; i++) {
      if (A[i] < A[i + 1]) {
        peak = i + 1;
      } else {
        break;
      }
    }
    if (peak > 0) {
      increasing = true;
    }
    for (int i = peak; i < A.length - 1; i++) {
      if (A[i] > A[i + 1]) {
        decreasing = true;
      } else {
        decreasing = false;
        break;
      }
    }
    return increasing && decreasing;
  }

  public int[] replaceElements(int[] arr) {
    for (int lion = 0; lion < arr.length - 1; lion++){
      int num = getGreatest(lion + 1 , arr);
      arr[lion] = num;
    }
    arr[arr.length -1] = -1;
    return arr;
  }

  private int getGreatest(int idx, int[] arr) {
    int max = -1;
    for (int j = idx; j < arr.length; j++){
      if(arr[j] > max)
        max = arr[j];
    }
    return max;
  }

  public int[] replaceElementsFast(int[] arr) {

    replace(arr, arr.length-1, -1);
    return arr;
  }

  private void replace(int[] arr, int ind, int val)
  {
    int temp = arr[ind];
    arr[ind] = val;
    if(ind == 0)
      return;
    replace(arr, --ind, Math.max(val, temp));
  }

  private void executeReplaceElements(){
    int[] A = {17,18,5,4,6,1};
    int[] B = {17,18,5,4,6,1};
    System.out.println("eexecuteReplaceElements...........");
    System.out.println(Arrays.toString(replaceElements(A)));
    System.out.println(Arrays.toString(replaceElementsFast(B)));
  }

  private void executeValidMountain() {
    System.out.println("executeValidMountain...........");
    int[] D = {3, 7, 6, 4, 3, 0, 1, 0};//false
    int[] A = {0, 1, 2, 3, 4, 5, 678, 677, 500, 300, 2, 1, 0};//true
    int[] B = {2, 1};//false
    int[] C = {3, 5, 5};//false
    System.out.println(validMountainArray(D));
    System.out.println(validMountainArray(A));
    System.out.println(validMountainArray(B));
    System.out.println(validMountainArray(C));
  }

  private void executeDuplicateZeros() {
    System.out.println("executeDuplicateZeros............");
    int[] A = {1, 0, 0, 2, 3, 0, 4, 5, 0};
    int[] B = {1};
    int[] C = {0};
    int[] D = {0, 0};
    int[] E = {0, 1};
    int[] F = {1, 0};
    int[] G = {1, 1};
    System.out.println(Arrays.toString(duplicateZeros(A)));
    System.out.println(Arrays.toString(duplicateZeros(B)));
    System.out.println(Arrays.toString(duplicateZeros(C)));
    System.out.println(Arrays.toString(duplicateZeros(D)));
    System.out.println(Arrays.toString(duplicateZeros(E)));
    System.out.println(Arrays.toString(duplicateZeros(F)));
    System.out.println(Arrays.toString(duplicateZeros(G)));

  }

  private void executeSortedSquares() {
    System.out.println("executeSortedSquares............");

    int[] B = {-4, -1, 0, 3, 10};
    int[] B1 = {-234, -123, -100, -33, -11, -4, -1, 1, 3, 10};
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

  private void executeIfExists() {
    int[] nums = {14, 1, 7, 2};
    System.out.println("\n");
    System.out.println("executeIfExists..........................");
    System.out.println(checkIfExist(nums));
  }

  private void executeSortArrayByParity() {
    System.out.println("executeSortArrayByParity....");
    int[] A = {3, 1, 2, 4};
    int[] B = {1, 1, 1, 0, 2, 1, 2, 0};
    System.out.println(Arrays.toString(sortArrayByParity(A)));
    System.out.println(Arrays.toString(sortArrayByParity(B)));
  }


}
