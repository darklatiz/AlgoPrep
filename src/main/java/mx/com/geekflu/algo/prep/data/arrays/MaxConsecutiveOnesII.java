package mx.com.geekflu.algo.prep.data.arrays;

/**
 * @see "Max Consecutive Ones II.md"
 */
public class MaxConsecutiveOnesII {

  public int findMaxConsecutiveOnes(int[] nums) {

    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return 1;

    int left = 0, right = 0;
    int maxConsecutiveOnes = 0;
    int onesCounter = 0;
    boolean wasFlipped = false;

    while (right < nums.length) {
      if (nums[right] == 1) {
        right++;
        onesCounter++;
        maxConsecutiveOnes = Math.max(maxConsecutiveOnes, onesCounter);
      } else if (!wasFlipped) {
        left = right;
        onesCounter++;
        right++;
        wasFlipped = true;
        maxConsecutiveOnes = Math.max(maxConsecutiveOnes, onesCounter);
      } else {
        maxConsecutiveOnes = Math.max(maxConsecutiveOnes, onesCounter);
        wasFlipped = false;
        onesCounter = 0;
        right = left + 1;
      }
    }
    return maxConsecutiveOnes;
  }

}
