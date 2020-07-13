package mx.com.geekflu.algo.prep.data.arrays;

public class FindPivot {

  public int pivotIndex(int[] nums) {
    if (nums == null) return -1;
    if (nums.length <= 2) return -1;

    int pivot = 0;
    int rightSum = 0;
    int leftSum = 0;

    for (int i = pivot + 1; i < nums.length; i++) {
      rightSum += nums[i];
    }

    for (int i = 0; i < pivot; i++) {
      leftSum += nums[i];
    }

    while (pivot < nums.length) {
      if (rightSum == leftSum) {
        return pivot;
      } else {
        pivot++;
        if (pivot < nums.length) {
          leftSum += nums[pivot - 1];
          rightSum -= nums[pivot];
        }
      }
    }
    return -1;
  }

}
