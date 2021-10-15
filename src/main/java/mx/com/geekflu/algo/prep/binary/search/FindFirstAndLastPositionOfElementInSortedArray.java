package mx.com.geekflu.algo.prep.binary.search;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class FindFirstAndLastPositionOfElementInSortedArray {

  public static int[] searchRange(int[] nums, int target) {
    int[] ans = {-1, -1};
    ans[0] = search(nums, target, true);
    if (ans[0] > -1) {
      ans[1] = search(nums, target, false);
    }
    return ans;
  }

  private static int search(int[] nums, int target, boolean isFirstIndex) {
    int start = 0;
    int end = nums.length - 1;
    int ans = -1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (target < nums[mid]) {
        end = mid - 1;
      } else if (target > nums[mid]) {
        start = mid + 1;
      } else {
        //possible index found
        ans = mid;
        if (isFirstIndex) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }
    }
    return ans;
  }

  public int[] kWeakestRows(int[][] mat, int k) {
    //brute force
    List<Pair> pairs = new ArrayList<>();
    if (mat == null || mat.length <= 0) {
      return new int[0];
    }

    float factor = (float) 1 / mat.length;
    for (int row = 0; row < mat.length; row++) {
      int numSoldiers = 0;
      for (int col = 0; col < mat[row].length; col++) {
        if (mat[row][col] == 1) {
          numSoldiers++;
        }
      }
      float res = (float) numSoldiers / mat[row].length * factor;
      pairs.add(new Pair(row, res));
    }
    Collections.sort(pairs);
    int[] weakest = new int[k];
    for (int i = 0; i < k; i++) {
      weakest[i] = pairs.get(i).row;
    }
    return weakest;

  }

  public static void main(String[] args) {
    int[][] integer2DArray = {
      {1, 1, 0, 0, 0},
      {1, 1, 1, 1, 0},
      {1, 0, 0, 0, 0},
      {1, 1, 0, 0, 0},
      {1, 1, 1, 1, 1}
    };

    var obj = new FindFirstAndLastPositionOfElementInSortedArray();
    obj.kWeakestRows(integer2DArray, 3);
  }

}

class Pair implements Comparable<Pair> {
  int row;
  float strength;

  public Pair(int row, float strength) {
    this.row = row;
    this.strength = strength;
  }

  @Override
  public int compareTo(Pair u) {
    if (this.strength < u.strength) {
      return -1;
    } else if (this.strength > u.strength) {
      return 1;
    } else {
      if (this.row < u.row) {
        return -1;
      }
      return 0;
    }
  }

  public static String traverseString(String myStr) {
    // Base case
    if (myStr.isEmpty()) {
      return myStr;
    }

    // Recursive case
    else {
      return traverseString(myStr.substring(1)) + myStr.charAt(0);
    }
  }
}
