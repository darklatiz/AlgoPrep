# Binary Search BootCamp

- [Binary Search in Detail](https://www.youtube.com/watch?v=f6UU7V3szVw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=10)
- This is a binary search bootcamp based on [YouTube Lecture by Kunal](https://www.youtube.com/watch?v=W9QJ8HaRvJQ&t=924s)

## Binary Search
- Used in SORTED arrays, Lists

### Algorithm

1. Given the nex list and target to be found
```javascript
target =  19
arr = [1, 2, 6, 8, 10, 12, 15, 16, 18, 19, 20]
```
2. Find the middle element using
```javascript
// 11 / 2 = 4.5 = 4
midIndex = arr.length / 2
// the mid element is arr[4] 
mid = arr[midIndex]
```
3. Based on this, mid = 10 and since target = 19 is greater, in a sorted array, this means that values before the middle point also are less than the target
   1. if target > middle value we search in the right
   2. else search in the left part
   3. if middle value == target we finish.

## Problem Ceiling of a number

- Ceiling find the smallest value in the array greater or equal to the target
```javascript
arr = [2, 3, 5, 9, 14, 16, 18]
ceiling(arr, target = 14) == 14
ceiling(arr, target = 15) == 16
ceiling(arr, target = 4) == 5
```
- In the case ceiling(arr, target = 15) == 16
  - 15 is not present in the array, so we take all the elements >= 15 [16, 18]
  - we take the smallest which is 16
- In the case ceiling(arr, target = 4) == 5
   - 4 is not present in the array, so we take all the elements >= 4 **[5, 9, 14, 16, 18]**
   - we take the smallest which is **5**
- The key point is when target is not found we return the updated value of start

## Problem Floor of a number in an Array
- Ceiling find the greatest value in the array small or equal to the target
```javascript
arr = [2, 3, 5, 9, 14, 16, 18]
floor(arr, target = 14) == 14
floor(arr, target = 4) == 3
```
- In the case floor(arr, target = 15) == 14
   - 15 is not present in the array, so we take all the elements <= 15 [2, 3, 5, 9, **14**]
   - we take the greatest which is 14
- In the case floor(arr, target = 4) == 3
   - 4 is not present in the array, so we take all the elements <= 4 [2, **3**]
   - we take the smallest which is **3**
- The key point is when target is not found we return the updated value of end

