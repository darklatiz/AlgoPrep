package mx.com.geekflu.algo.prep.data.leetcode;

/**
 Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

 Return the array in the form [x1,y1,x2,y2,...,xn,yn].

 Example 1:

 Input: nums = [2,5,1,3,4,7], n = 3
 Output: [2,3,5,4,1,7]
 Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 Example 2:

 Input: nums = [1,2,3,4,4,3,2,1], n = 4
 Output: [1,4,2,3,3,2,4,1]
 Example 3:

 Input: nums = [1,1,2,2], n = 2
 Output: [1,2,1,2]
 */
public class ShuffleTheArray {

  public int[] shuffle(int[] nums, int n) {
    if(nums == null || nums.length <= 0) {
      return nums;
    }
    int xIndex = 0;
    int yIndex = n;
    int[] result = new int[2 * n];

    for(int index = 0; index < 2 * n; index++) {
      // if the index is even belongs to x
      if(index % 2 == 0) {
        result[index] = nums[xIndex++];
      }else {
        result[index] = nums[yIndex++];
      }
    }
    return result;
  }

}
