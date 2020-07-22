package mx.com.geekflu.algo.prep.data.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

  public static void main(String[] args) {
    String[] words = {"hola", "holanes", "holanesito"};
    PascalTriangle pt = new PascalTriangle();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('a');
    stringBuilder.append('b');
    stringBuilder.append('c');

    pt.runningSum(new int[]{1, 2, 3, 4});
    pt.longestCommonPrefix(words);
  }

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    if (numRows <= 0) return triangle;


    List<Integer> firstRow = new ArrayList<>();
    firstRow.add(1);
    triangle.add(firstRow);

    if (numRows == 1) return triangle;

    List<Integer> secondRow = new ArrayList<>();
    secondRow.add(1);
    secondRow.add(1);
    triangle.add(secondRow);

    if (numRows == 2) return triangle;

    for (int i = 2; i < numRows; i++) {
      List<Integer> prev = triangle.get(i - 1);
      List<Integer> current = new ArrayList<>();
      current.add(1);
      for (int j = 1; j < i; j++) {
        current.add(prev.get(j - 1) + prev.get(j));
      }
      current.add(1);
      triangle.add(current);
    }
    return triangle;
  }

  public int strStr(String haystack, String needle) {
    int index = haystack.indexOf(needle);
    return index;
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    StringBuilder stringBuilder = new StringBuilder();
    for (int word = 0; word < strs.length; word++) {
      char[] ws = strs[word].toCharArray();
      char[] ws1 = strs[word + 1].toCharArray();
      boolean match = true;
      int index = 0;
      while (match) {
        if (ws.length > index && ws1.length > index && ws[index] == ws1[index]) {
          stringBuilder.append(ws[index]);
          index++;
        } else {
          match = false;
        }
      }
    }
    return "";
  }

  public int[] runningSum(int[] nums) {
    if (nums == null || nums.length == 0) return new int[1];

    for (int i = 1; i < nums.length; i++) {
      nums[i] = nums[i - 1] + nums[i];
    }
    return nums;
  }
}
