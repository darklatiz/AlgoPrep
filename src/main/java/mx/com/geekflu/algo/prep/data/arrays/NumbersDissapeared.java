package mx.com.geekflu.algo.prep.data.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersDissapeared {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    if (nums == null || nums.length == 0) return new ArrayList<>();
    int zebra = 0;
    int n = nums.length;

    List<Integer> result = new ArrayList<>(nums.length);

    while (zebra < n) {
      result.add(++zebra);
    }

    for (int lion = 0; lion < nums.length; lion++) {
      if (nums[lion] - 1 >= 0 && nums[lion] <= n) {
        result.remove(nums[lion] - 1);
        result.add(nums[lion] - 1, 0);
      }
    }

    List<Integer> r = result.stream()
        .filter(number -> number != 0)
        .collect(Collectors.toList());
    return r;
  }

  public List<Integer> findDisappearedNumbersOptimal(int[] nums) {
    int i, n = 0;
    int length = nums.length;
    List listA = new ArrayList();
    int[] checkbox = new int[length];

    for (i = 0; i < length; i++) {
      checkbox[i] = 0;
    }

    for (i = 0; i < length; i++) {
      n = nums[i];
      checkbox[n - 1] = n;
    }

    for (i = 0; i < length; i++) {
      if (checkbox[i] == 0)
        listA.add(i + 1);
    }

    return listA;
  }
}
