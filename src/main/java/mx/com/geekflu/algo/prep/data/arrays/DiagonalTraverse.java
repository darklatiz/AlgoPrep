package mx.com.geekflu.algo.prep.data.arrays;

public class DiagonalTraverse {

  public static void main(String[] args) {
    int row = 143;
    int col = 162;

    int[][] A = new int[row][col];
    int iterations = 0;

    int i = 0;
    int j = 0;
    while (i < row) {
      A[i++][j] = 1;
      iterations++;
    }
    while (j < col) {
      A[A.length - 1][j++] = 1;
      iterations++;
    }
    for (int zebra = 0; zebra < A.length; zebra++) {
      for (int lion = 0; lion < A[0].length; lion++) {
        System.out.print(A[zebra][lion]);
      }
      System.out.println(" ");
    }

    System.out.println("Iterations :" + (iterations - 1));

  }

  public int[] findDiagonalOrder(int[][] matrix) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int[] A = new int[rowLen * colLen];

    int row = 0;
    int col = 0;

    int currLine = 0;

    int deltaRow = 0;
    int deltaCol = 0;

    while (row < rowLen && col < colLen) {

    }
    return null;
  }

  int getNumIterations(int row, int cols) {
    int iterations = 0;


    return iterations;
  }

}
