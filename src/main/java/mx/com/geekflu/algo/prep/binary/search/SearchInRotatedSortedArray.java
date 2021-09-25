package mx.com.geekflu.algo.prep.binary.search;

public class SearchInRotatedSortedArray {

  private SearchInRotatedSortedArray() {}

  public static int search(int[] nums, int target) {
    int rotatedIndex = findRotatedIndex(nums);
    if (rotatedIndex == 0) {
      return search(nums, 0, nums.length - 1, target);
    }else if (target < nums[0]) {
      // number is on the right part of th array
      return search(nums, rotatedIndex, nums.length - 1, target);
    }else if(target > nums[0]){
      // number is on the left part of th array
      return search(nums, 0, rotatedIndex - 1, target);
    }else {
      return 0;
    }
  }

  private static int search(int[] nums, int start, int end, int target) {
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (target < nums[mid]) {
        end = mid - 1;
      }else if (target > nums[mid]) {
        start = mid + 1;
      }else {
        return mid;
      }
    }
    return -1;
  }


  /**
   * Find the rotated index in a int array [4,5,6,7,8,0,1,2,3]
   * @param nums
   * @return rotated index
   */
  public static int findRotatedIndex(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }else if (nums.length == 2) {
      if(nums[0] > nums[1]) {
        return 1;
      }else{
        return 0;
      }
    }

    int start = 0;
    int end = nums.length - 1;

    int gStart = 0;
    int gEnd = nums.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if ( (mid + 1) >= nums.length  ||  (mid > 0 && nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1])) {
        return mid;
      }else {
        if (nums[mid] > nums[gStart] && nums[mid] > nums[gEnd]) {
          start = mid + 1;
        }else {
          end = mid - 1;
        }
      }
    }
    return 0;
  }
}
