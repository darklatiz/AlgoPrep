package mx.com.geekflu.algo.prep.sorting;

import java.util.Arrays;

public class MergeSort {

  /**
   * Sort an array of integers using merge sort
   * @param arr
   */
  public static int[] mergeSort(int[] arr) {
    if (arr.length == 1) {
      return arr;
    }

    int mid = arr.length / 2;

    int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
    int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

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
