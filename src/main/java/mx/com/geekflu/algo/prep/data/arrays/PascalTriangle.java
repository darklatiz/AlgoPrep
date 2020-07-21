package mx.com.geekflu.algo.prep.data.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

  public List<List<Integer>> generate(int numRows) {
    BigInteger
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

  }

}
