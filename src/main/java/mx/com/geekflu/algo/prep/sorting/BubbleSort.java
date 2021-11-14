package mx.com.geekflu.algo.prep.sorting;

import java.util.Objects;

public class BubbleSort {

  public static void sort(int[] nums){
    if(Objects.isNull(nums) || nums.length <= 0){
      return;
    }

    for(var i = 0; i < nums.length; i++){
      for(var j = 0; j < nums.length - i - 1; j++){
        if(nums[j] > nums[j + 1] ){
          SortingUtils.swap(nums, j, j + 1);
        }
      }
    }
  }

}
