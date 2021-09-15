package mx.com.geekflu.algo.prep.binary.search;

import java.util.Objects;

public class BinarySearch {

  public static void main(String[] args) {

  }

  /**
   * Binary search function will return the index of the target if exists
   * we can send either an increasing or decreasing array
   * @param arr, this the array of sorted elements can be in Increasing or descending order
   * @param target, this is the target to be found
   * @return index of the element if exists otherwise returns -1
   */
  public static int binarySearch(Integer[] arr, int target) {
    if (Objects.isNull(arr))
      return -1;
    if (arr.length <= 0)
      return -1;

    int start = 0;
    int end = arr.length - 1;
    boolean isIncreasing = arr[start] < arr[end];


    while (start <= end) {
      // this way may overflow int values
//      int midIndex = (end + start) / 2;
      int midIndex = start + (end - start) / 2;
      int midPointValue = arr[midIndex];

      // we found the target value in the array
      if (target == midPointValue) {
        return midIndex;
      }

      // we search on the left so we adjust end pointer
      if (isIncreasing) {
        if (target < midPointValue) {
          end = midIndex - 1;
        }else {
          // it is on the right we adjust start
          start = midIndex + 1;
        }
      }else {
        //decreasing array
        if (target > midPointValue) {
          end = midIndex - 1;
        }else {
          start = midIndex + 1;
        }
      }
    }
    return -1;
  }

}
