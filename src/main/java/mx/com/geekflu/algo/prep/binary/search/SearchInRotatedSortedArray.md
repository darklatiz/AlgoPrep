# Search in Rotated Sorted Array

```javascript
[4,5,6,7,8,9,0,1,2,3] // <-- rotated array index 6 (zero based)
[1,2,3] // <-- increasing array
[3,2,1] // <-- decreasing array
[1] // <-- one element array
```
We need find a **target** in any of these arrays and **return its index**.

Possibly we can take the next approach:
- Search for the element based on the side of the array
  - We will probably have two sides of the array one increasing and the other decreasing

# Possible Solution

1. Find if rotated array
   1. To find the rotated index we should apply the next algorithm
      1. 
      ```javascript
      arr = [3, 4, 5, 6, 7, 1, 2, 3]
      globalStart = start = 0
      globalEnd = end = 7
      mid = (0 + 7) / 2 //mid is 3
      while (start <= end) {
        if (arr[mid - 1] > arr[mid] < arr[mid + 1]) {
            return mid; //this is the smallest
        }else{
            //in which side of the array am I? right or left
            if(arr[globalStart] < arr[mid] > arr[globalEnd]) {
            // we are in the right part of the array so we have to move towards the beginning
                start = mid + 1
            }else {
                end = mid - 1
            }
        }
      }
      ```
   2. Once we have the rotated index we can search based on it
      1. if **target** < **nums[0]** this means that the target is on the right side of the array, so we search from **rotatedIndex** to **end of array**
      2. else we search from 0 to rotatedIndex - 1
      3. return value if exists