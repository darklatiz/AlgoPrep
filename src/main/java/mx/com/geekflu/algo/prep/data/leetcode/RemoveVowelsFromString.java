package mx.com.geekflu.algo.prep.data.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RemoveVowelsFromString {

  /**
   *
   * @param input
   * @return
   */
  public String removeVowels(String input) {
    if (input == null || input.length() <= 0) {
      return input;
    }

    StringBuilder stringBuilder = new StringBuilder();
    Set<Character> vowels = getVowels();

    for (int i = 0; i < input.length(); i++) {
      if (!vowels.contains(input.charAt(i))) {
        stringBuilder.append(input.charAt(i));
      }
    }
    return stringBuilder.toString();
  }

  private Set<Character> getVowels() {
    Set<Character> s =new HashSet<>();
    s.add('A');
    s.add('a');

    s.add('E');
    s.add('e');

    s.add('I');
    s.add('i');

    s.add('O');
    s.add('o');

    s.add('U');
    s.add('u');
    return s;
  }

}
