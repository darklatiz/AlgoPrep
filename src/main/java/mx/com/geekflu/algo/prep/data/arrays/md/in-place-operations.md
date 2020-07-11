##  In-Place Array Operations Introduction

````
In programming interviews, the interviewer often expects 
you to minimise the time and space complexity of your implementation. 
In-place Array operations help to reduce space complexity, and so are a
class of techniques that pretty much everybody encounters regularly in
 interviews.
````

So, what are in-place array operations?

The best way of answering this question is to look at an example.

````
Given an Array of integers, return an Array where every element at an even-indexed position is squared.

Input: array = [9, -2, -9, 11, 56, -12, -3]
Output: [81, -2, 81, 11, 3136, -12, 9]
Explanation: The numbers at even indexes (0, 2, 4, 6) have been squared, 
whereas the numbers at odd indexes (1, 3, 5) have been left the same.
````

````java
public class Solution{
  public int[] squareEven(int[] array, int length) {
  
    // Check for edge cases.
    if (array == null) {
      return array;
    }
  
    // Iterate through the original array.
    for(int i = 0; i < length; i++) {
  
      // If the index is an even number, then we need to square the element
      // and replace the original value in the Array.
      if (i % 2 == 0) {
        array[i] *= array[i];
      }
      // Notice how we don't need to do *anything* for the odd indexes? :-)
    }
  
    // We just return the original array. Some problems on leetcode require you
    // to return it, and other's dont.
    return array;
  }
}
````

