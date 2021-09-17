# Smallest Letter

Given a characters array letters that is sorted in non-decreasing order and a character target, 
return the smallest character in the array that is larger than target.

**Note** that the letters wrap around.
- For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.

**Example 1:**
```javascript
Input: letters = ["c","f","j"], target = "a"
Output: "c"
```

**Example 2:**
```javascript
Input: letters = ["c","f","j"], target = "c"
Output: "f"
```

**Example 3:**
```javascript
Input: letters = ["c","f","j"], target = "d"
Output: "f"
```

**Example 4:**
```javascript
Input: letters = ["c","f","j"], target = "g"
Output: "j"
```

**Example 5:**
```javascript
Input: letters = ["c","f","j"], target = "j"
Output: "c"
```


## Analysis

By removing if middle value == target


