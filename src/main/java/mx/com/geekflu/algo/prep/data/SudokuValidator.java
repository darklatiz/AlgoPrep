package mx.com.geekflu.algo.prep.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SudokuValidator {

  private final Map<Integer, Set<Character>> MISSING_ROW_NUMBERS = new HashMap<>();
  private final Map<Integer, Set<Character>> PRESENT_ROW_NUMBERS = new HashMap<>();

  private final Map<Integer, Set<Character>> MISSING_COL_NUMBERS = new HashMap<>();
  private final Map<Integer, Set<Character>> PRESENT_COL_NUMBERS = new HashMap<>();

  private final Map<Integer, Set<Character>> MISSING_BOX_NUMBERS = new HashMap<>();
  private final Map<Integer, Set<Character>> PRESENT_BOX_NUMBERS = new HashMap<>();

  public static void main(String[] args) {
    char[][] board = {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    SudokuValidator sudokuValidator = new SudokuValidator();
    sudokuValidator.solveSudoku(board);
    System.out.println(sudokuValidator.isValidSudoku(board));

  }

  public void solveSudoku(char[][] board) {
    if (!isASudokuValidBoard(board)) {
      return;
    }

    // analize first rows
    for(int row = 0; row < 9; row++) {
      Set<Character> missingRowNumbers = getMissingRowNumbers(board, row);
      MISSING_ROW_NUMBERS.put(row, missingRowNumbers);

      Set<Character> missingColNumbers = getMissingColNumbers(board, row);
      MISSING_COL_NUMBERS.put(row, missingColNumbers);
    }

    //get missing numbers per 3x3 box
    int boxNumber = 0;
    for(var i = 0; i < 9; i+=3){
      int outIni = mapLowerLimit(i/3);
      int outEnd = mapUpperLimits(i/3);
      for(var j = 0; j < 9; j+=3 ){
        Map<Character, Integer> elements = new HashMap<>();
        int inIni = mapLowerLimit(j/3);
        int inEnd = mapUpperLimits(j/3);

        for(var o = outIni; o <= outEnd; o++){
          for(var in = inIni; in <= inEnd; in++){
             if (board[o][in] == '.') {
               continue;
             }
             if (!elements.containsKey(board[o][in])) {
               elements.put(board[o][in], 1);
             }
          }
        }

        PRESENT_BOX_NUMBERS.put(boxNumber, new HashSet<>(elements.keySet()));

        Set<Character> characters = new HashSet<>();
        if(elements.size() < 9){
          for (int c = '1'; c <= '9'; c++){
            char current = (char) c;
            if (!elements.containsKey(current)) {
              characters.add(current);
            }
          }
        }
        MISSING_BOX_NUMBERS.put(boxNumber, characters);
        boxNumber++;
      }
    }

    // iterate over the board and  check for every '.'
    // 1. get row missing numbers an iterate over the numbers and check if it is possible to place a number in that cell
    for(var row = 0; row < 9 ; row++){
      for(var col = 0; col < 9; col++){
        char current = board[row][col];
        if (current == '.') {

        }
      }

    }





    System.out.println(MISSING_ROW_NUMBERS);

  }

  private Integer getBoxNumber(int row, int col) {
    if(row == 0) {
      if(col == 0){
        return 0;
      }else if(col == 1){
        return 1;
      }else if(col == 2){
        return 2;
      }
    }else if(row == 1) {
      if(col == 0){
        return 3;
      }else if(col == 1){
        return 4;
      }else if(col == 2){
        return 5;
      }
    }else if(row == 2) {
      if(col == 0){
        return 6;
      }else if(col == 1){
        return 7;
      }else if(col == 2){
        return 8;
      }
    }
    return -1;
  }

  public Set<Character> getMissingRowNumbers(char[][] board, int row){
    return getMissingNumbers(board, row, true);
  }

  public Set<Character> getMissingColNumbers(char[][] board, int col){
    return getMissingNumbers(board, col,false);
  }

  private Set<Character> getMissingNumbers(char[][] board, int pivot, boolean isRow){
    Map<Character, Integer> elements = new HashMap<>();
    if (isRow) {
      for (int col = 0; col < 9; col++){
        if(board[pivot][col] == '.'){
          continue;
        }

        if(!elements.containsKey(board[pivot][col])){
          elements.put(board[pivot][col], 1);
        }
      }
    }else {
      for (int col = 0; col < 9; col++){
        if(board[col][pivot] == '.'){
          continue;
        }

        if(!elements.containsKey(board[col][pivot])){
          elements.put(board[col][pivot], 1);
        }
      }
    }

    if (isRow) {
      PRESENT_ROW_NUMBERS.put(pivot, new HashSet<>(elements.keySet()));
    }else {
      PRESENT_COL_NUMBERS.put(pivot, new HashSet<>(elements.keySet()));
    }

    Set<Character> characters = new HashSet<>();
    if (elements.size() < 9) {
      for (int num = '1'; num <= '9'; num++) {
        char current = (char) num;
        if (!elements.containsKey(current)) {
          characters.add(current);
        }
      }
    }

    return characters;

  }

  private boolean isASudokuValidBoard(char[][] theBoard) {
    if (Objects.isNull(theBoard)) {
      return false;
    }

    if (theBoard.length != 9) {
      return false;
    }

    for (var i = 0; i < 9; i++) {
      if (theBoard[i].length != 9) {
        return false;
      }
    }

    return true;
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

    for (var i = 0; i < 9; i += 3) {
      int iDx = i / 3;
      int outerI = mapLowerLimit(iDx);
      int outerJ = mapUpperLimits(iDx);
      for (var j = 0; j < 9; j += 3) {
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
