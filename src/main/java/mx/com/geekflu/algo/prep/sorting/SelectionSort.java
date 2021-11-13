package mx.com.geekflu.algo.prep.sorting;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class SelectionSort {

  private SelectionSort(){}

  public static void sort(int[] nums) {

    if(Objects.isNull(nums) || nums.length <= 0){
      return;
    }

    for (var i = 0; i < nums.length; i++) {
      int minIdx = findMinIndex(nums, i);
      SortingUtils.swap(nums, i, minIdx);
    }
  }

  private static int findMinIndex(int[] nums, int start) {
    int min = Integer.MAX_VALUE;
    int index = -1;
    for(var i = start; i < nums.length; i++){
      if(nums[i] < min){
        min = nums[i];
        index = i;
      }
    }
    return index;
  }


}
