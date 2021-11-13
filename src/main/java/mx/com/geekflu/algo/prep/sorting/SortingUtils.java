package mx.com.geekflu.algo.prep.sorting;

public class SortingUtils {
  private SortingUtils(){}

  public static void swap(int[] nums, int i, int j) {
    var temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
