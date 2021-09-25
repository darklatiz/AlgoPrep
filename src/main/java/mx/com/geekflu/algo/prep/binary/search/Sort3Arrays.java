package mx.com.geekflu.algo.prep.binary.search;

import java.util.ArrayList;
import java.util.List;

public class Sort3Arrays {


  public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
    List<Integer> intersection = new ArrayList<>();
    for(var target : arr1) {
      if (search(arr2, target) && search(arr3, target)) {
        intersection.add(target);
      }
    }
    return intersection;
  }

  private static boolean search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while(start <= end) {
      int mid = start + (end - start) / 2;
      if (target < nums[mid]) {
        end = mid -1;
      }else if (target > nums[mid]) {
        start = mid + 1;
      }else {
        return true;
      }
    }
    return false;
  }

}
