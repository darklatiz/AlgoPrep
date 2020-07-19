package mx.com.geekflu.algo.prep.data.arrays;

public class DiagonalTraverse {

  public static void main(String[] args) {
    int row = 10;
    int col = 10;

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
    int[][] m = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
    diagonalTraverse.findDiagonalOrder(m);
  }

  public int[] findDiagonalOrder(int[][] matrix) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int[] A = new int[rowLen * colLen];
    int iterations = rowLen + colLen - 1;
    int index = 0;

    for (int i = 0; i < iterations; i++) {
      if (i % 2 == 0) {
        int x = i < rowLen ? i : rowLen - 1;
        int y = i < rowLen ? 0 : i - (rowLen - 1);
        while (x >= 0 && y < colLen) {
          A[index++] = matrix[x--][y++];
        }
      } else {
        int x = i < colLen ? 0 : i - (colLen - 1);
        int y = i < colLen ? i : colLen - 1;
        while (x < rowLen && y >= 0) {
          A[index++] = matrix[x++][y--];
        }
      }
    }


    return A;
  }

  int getNumIterations(int row, int cols) {
    int iterations = 0;


    return iterations;
  }

}
