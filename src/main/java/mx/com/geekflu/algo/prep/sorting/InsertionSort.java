package mx.com.geekflu.algo.prep.sorting;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class InsertionSort {

  private InsertionSort(){}

  public static void sort(int[] nums) {
    if(Objects.isNull(nums) || nums.length <= 0){
      return;
    }

    for(var i = 0; i < nums.length; i++){
      int j = i;
      while (j > 0 && nums[j - 1] > nums[j]) {
        SortingUtils.swap(nums, j - 1, j);
        j = j - 1;
      }
    }
  }

}
