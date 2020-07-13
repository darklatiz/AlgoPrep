package mx.com.geekflu.algo.prep.data.arrays;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {

  public int thirdMaxAproach1(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    Set<Integer> singleNums = new HashSet<>();

    for (int n : nums) singleNums.add(n);

    int max = Collections.max(singleNums);

    if (singleNums.size() < 3) return max;

    singleNums.remove(max);
    singleNums.remove(Collections.max(singleNums));
    return Collections.max(singleNums);
  }

  public int thirdMaxAproach2(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    Set<Integer> singleNums = new HashSet<>();

    for (int n : nums) singleNums.add(n);

    int max = Collections.max(singleNums);

    if (singleNums.size() < 3) return max;

    singleNums.remove(max);
    singleNums.remove(Collections.max(singleNums));
    return Collections.max(singleNums);
  }


}
