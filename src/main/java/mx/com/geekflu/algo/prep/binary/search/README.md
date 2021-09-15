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