package mx.com.geekflu.algo.prep.data.arrays;

public class DiagonalTraverse {

  public int[] findDiagonalOrder(int[][] matrix) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int[] A = new int[rowLen * colLen];
    int row = 0;
    int col = 0;
    int currLine = 0;
    while (row < rowLen && col < colLen) {
      if (currLine == col + row) {
        A[0] = matrix[row][col];
      }
    }
    return null;
  }


}
