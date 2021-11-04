package mx.com.geekflu.algo.prep.data;

import java.util.HashMap;
import java.util.Map;

public class SudokuValidator {


  public static void main(String[] args) {
    char[][] board = {
      {'5','3','.','.','7','.','.','.','.'},
      {'6','.','.','1','9','5','.','.','.'},
      {'.','9','8','.','.','.','.','6','.'},
      {'8','.','.','.','6','.','.','.','3'},
      {'4','.','.','8','.','3','.','.','1'},
      {'7','.','.','.','2','.','.','.','6'},
      {'.','6','.','.','.','.','2','8','.'},
      {'.','.','.','4','1','9','.','.','5'},
      {'.','.','.','.','8','.','.','7','9'}
    };
    SudokuValidator sudokuValidator = new SudokuValidator();
    System.out.println(sudokuValidator.isValidSudoku(board));

  }

  public boolean isValidSudoku(char[][] board) {
    // we can iterate over the rows and validate if it is a valid character between 1 and 9
    if (board == null) {
      return false;
    }

    if (board.length != 9) {
      return false;
    }

    for (var i = 0; i < 9; i++) {
      if (board[i].length != 9) {
        return false;
      }
    }

    // validate each row
    for (var i = 0; i < 9; i++) {
      Map<Character, Integer> uniques = new HashMap<>();
      for (var j = 0; j < 9; j++) {

        if (board[i][j] == '.') {
          continue;
        }

        if (uniques.containsKey(board[i][j])) {
          return false;
        } else {
          uniques.put(board[i][j], 1);
        }
      }
    }

    for (var i = 0; i < 9; i++) {
      Map<Character, Integer> uniques = new HashMap<>();
      for (var j = 0; j < 9; j++) {

        if (board[j][i] == '.') {
          continue;
        }

        if (uniques.containsKey(board[j][i])) {
          return false;
        } else {
          uniques.put(board[j][i], 1);
        }
      }
    }

    for (var i = 0; i < 9; i+=3) {
      int iDx = i / 3;
      int outerI = mapLowerLimit(iDx);
      int outerJ = mapUpperLimits(iDx);
      for (var j = 0; j < 9; j+=3) {
        int jDx = j / 3;
        int innerI = mapLowerLimit(jDx);
        int innerJ = mapUpperLimits(jDx);
        Map<Character, Integer> uniques = new HashMap<>();


        for (var t = outerI; t <= outerJ; t++) {
          for (var q = innerI; q <= innerJ; q++) {

            if (board[t][q] == '.') {
              continue;
            }

            if (uniques.containsKey(board[t][q])) {
              return false;
            } else {
              uniques.put(board[t][q], 1);
            }
          }
        }

      }
    }

    return true;

  }

  private int mapLowerLimit(int index) {
    if (index == 0) {
      return 0;
    } else if (index == 1) {
      return 3;
    } else if (index == 2) {
      return 6;
    }

    return -1;
  }

  private int mapUpperLimits(int index) {
    if (index == 0) {
      return 2;
    } else if (index == 1) {
      return 5;
    } else if (index == 2) {
      return 8;
    }

    return -1;
  }
}