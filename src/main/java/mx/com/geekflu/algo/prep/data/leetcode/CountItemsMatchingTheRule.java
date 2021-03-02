package mx.com.geekflu.algo.prep.data.leetcode;
import java.util.List;

/**
 You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item.
 You are also given a rule represented by two strings, ruleKey and ruleValue.

 The ith item is said to match the rule if one of the following is true:

 ruleKey == "type" and ruleValue == typei.
 ruleKey == "color" and ruleValue == colori.
 ruleKey == "name" and ruleValue == namei.
 Return the number of items that match the given rule.



 Example 1:

 Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 Output: 1
 Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
 Example 2:

 Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 Output: 2
 Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.
 */
public class CountItemsMatchingTheRule {

  public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    if(items == null || items.isEmpty()) {
      return Integer.MIN_VALUE;
    }

    int index2Check = Integer.MIN_VALUE;
    if (ruleKey.equalsIgnoreCase("type")){
      index2Check = 0;
    }else if(ruleKey.equalsIgnoreCase("color")) {
      index2Check = 1;
    } else if(ruleKey.equalsIgnoreCase("name")) {
      index2Check = 2;
    }
    int matches = 0;
    for(List<String> row : items) {
      if(row.get(index2Check).equalsIgnoreCase(ruleValue)){
        matches++;
      }
    }

    return matches;

  }

}
