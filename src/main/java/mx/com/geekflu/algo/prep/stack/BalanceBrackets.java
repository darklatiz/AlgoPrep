package mx.com.geekflu.algo.prep.stack;

import java.util.LinkedList;

public class BalanceBrackets {

  private BalanceBrackets() {}

  public static boolean isBalance(String brackets) {
    LinkedList<Character> opens = new LinkedList<>();
    for (Character current: brackets.toCharArray()) {
      if (isValidOpenBracket(current)) {
        opens.push(current);
      }else {
        if (opens.isEmpty()) {
          return false;
        }else{
          char topElement = opens.peek();
          if (isValidOpenBracket(topElement) && isValidCloseBracket(current)) {
            opens.pop();
          }else {
            return false;
          }
        }
      }
    }
    // if empty it is balanced otherwise it is not balanced
    return opens.isEmpty();
  }

  public static String balanceBrackets(String brackets) {
    LinkedList<Character> openBracketsStack = new LinkedList<>();
    int openBracketNeeded = 0;
    for(Character current : brackets.toCharArray()) {
      if (isValidOpenBracket(current)) {
        openBracketsStack.push(current);
      }else {
        if (openBracketsStack.isEmpty()) {
          openBracketNeeded++;
        }else {
          if (isValidOpenBracket(openBracketsStack.peek()) && isValidCloseBracket(current)) {
            openBracketsStack.pop();
          }
        }
      }
    }

    String openBrackets = "<".repeat(Math.max(0, openBracketNeeded));
    String closeBrackets = ">".repeat(openBracketsStack.size());

    return openBrackets + brackets + closeBrackets;

  }

  private static boolean isValidOpenBracket(Character character) {
    return character == '<' || character == '[' || character == '{' || character == '(';
  }

  private static boolean isValidCloseBracket(Character character) {
    return character == '>' || character == ']' || character == '}' || character == ')';
  }

}
