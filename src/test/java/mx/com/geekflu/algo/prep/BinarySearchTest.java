package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.binary.search.BinarySearch;
import mx.com.geekflu.algo.prep.binary.search.FindSmallestLetter;
import mx.com.geekflu.algo.prep.util.Util;
import org.junit.Assert;
import org.junit.Test;


@Slf4j
public class BinarySearchTest {

  @Test
  public void test_binary_search_int() {
    Integer[] array = Util.generateArray(1000, true);
    array[999] = 10001;
    int targetIndex = BinarySearch.binarySearch(array, 10001);
    Assert.assertEquals(999, targetIndex);

    targetIndex = BinarySearch.binarySearch(array, -12345);
    Assert.assertEquals(-1, targetIndex);

    Assert.assertEquals(-1, BinarySearch.binarySearch(null, 1));

    Integer[] zero = new Integer[0];
    Assert.assertEquals(-1, BinarySearch.binarySearch(zero, 1));
  }

  @Test
  public void test_binary_search_int_descending() {
    Integer[] array = new Integer[]{1000, 999, 888, 777, 666, 555, 444, 333, 222, 111, 99, 88, 77, 66, 55, 44, 33, 22, 11, 9, 8, 7};
    int targetIndex = BinarySearch.binarySearch(array, 333);
    Assert.assertEquals(7, targetIndex);
    Assert.assertEquals(0, BinarySearch.binarySearch(array, 1000));
    Assert.assertEquals(21, BinarySearch.binarySearch(array, 7));
    Assert.assertEquals(15, BinarySearch.binarySearch(array, 44));
  }

  @Test
  public void test_ceil() {
    Integer[] array = new Integer[]{2, 3, 5, 9, 14, 16, 18};
    Assert.assertEquals(5, BinarySearch.ceil(array, 15));
  }

  @Test
  public void test_floor() {
    Integer[] array = new Integer[]{2, 3, 5, 9, 14, 16, 18};
    Assert.assertEquals(4, BinarySearch.floor(array, 15));
  }

  @Test
  public void test_smallest_letters() {
    char[] chars = new char[]{'c', 'f', 'j'};
    Assert.assertEquals('c', FindSmallestLetter.findSmallestLetter(chars, 'a'));
    Assert.assertEquals('f', FindSmallestLetter.findSmallestLetter(chars, 'c'));
    Assert.assertEquals('f', FindSmallestLetter.findSmallestLetter(chars, 'd'));
    Assert.assertEquals('j', FindSmallestLetter.findSmallestLetter(chars, 'g'));
    Assert.assertEquals('c', FindSmallestLetter.findSmallestLetter(chars, 'j'));
  }

}
