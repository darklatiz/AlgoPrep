package mx.com.geekflu.algo.prep.data.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length <= 0) {
      return new int[0];
    }
    Map<Integer, Integer> mapOfVisited = new HashMap<>();
    for(int i = 0 ; i < nums.length; i++) {
      int complement = target - nums[i];
      if(mapOfVisited.containsKey(complement)) {
        return new int[] {mapOfVisited.get(complement), i};
      }else {
        mapOfVisited.put(nums[i], i);
      }
    }
    return new int[0];
  }
}
