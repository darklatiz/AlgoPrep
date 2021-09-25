package mx.com.geekflu.algo.prep.binary.search;

public class SearchInRotatedSortedArray {


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
      if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
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
