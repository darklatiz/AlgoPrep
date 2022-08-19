package mx.com.geekflu.algo.prep.sorting;

import java.util.Arrays;
import java.util.Objects;

public class MergeSort {

  private MergeSort(){}

  public static void mergeSort(int[] nums){
    if(Objects.isNull(nums) || nums.length <= 0){
      return;
    }

    mergeSort(nums, 0, nums.length - 1);

  }

  private static void mergeSort(int[] array, int start, int end) {
    if(start >= end){
      return;
    }

    int mid = start + (end - start) / 2;
    mergeSort(array, start, mid);
    mergeSort(array, mid + 1, end);
    mergeHalves(array, start, end);
  }

  private static void mergeHalves(int[] array, int start, int end) {
    int[] temp = new int[array.length];
    
  }

  /**
   * Sort an array of integers using merge sort
   * @param arr
   */
  public static int[] mergeSortUsingExtraSpace(int[] arr) {
    if (arr.length == 1) {
      return arr;
    }

    int mid = arr.length / 2;

    int[] left = mergeSortUsingExtraSpace(Arrays.copyOfRange(arr, 0, mid));
    int[] right = mergeSortUsingExtraSpace(Arrays.copyOfRange(arr, mid, arr.length));

    return merge(left, right);

  }

  private static int[] merge(int[] first, int[] second) {
    int i = 0;
    int j = 0;
    int k = 0;
    int[] merged = new int[first.length + second.length];

    while (i < first.length && j < second.length) {
      if (first[i] < second[j]) {
        merged[k] = first[i];
        k++;
        i++;
      }else {
        merged[k] = second[j];
        k++;
        j++;
      }
    }

    while(i < first.length) {
      merged[k] = first[i];
      k++;
      i++;
    }

    while (j < second.length){
      merged[k] = second[j];
      k++;
      j++;
    }
    return merged;
  }

}
