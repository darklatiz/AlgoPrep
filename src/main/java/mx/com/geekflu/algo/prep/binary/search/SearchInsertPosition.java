package mx.com.geekflu.algo.prep.binary.search;

public class SearchInsertPosition {

  public static int searchInsert(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
      int midIndex = start + (end - start) / 2;
      int midValue = nums[midIndex];

      if (target < midValue) {
        end = midIndex - 1;
      }else if (target > midValue) {
        start = midIndex + 1;
      }else {
        return midIndex;
      }
    }

    if(end < 0) {
      return 0;
    }else if (start >= nums.length) {
      return nums.length;
    }else {
      return start;
    }
  }

}
