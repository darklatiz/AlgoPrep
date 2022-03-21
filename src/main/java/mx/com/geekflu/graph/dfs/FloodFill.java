package mx.com.geekflu.graph.dfs;

import mx.com.geekflu.algo.prep.data.linked.list.LinkedList;

public class FloodFill {

  public static final int[][] DIRECTIONS = {
    {1, 0}, // right
    {-1, 0}, // left
    {0, 1}, // down
    {0, -1}  // up
  };

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image == null || image.length == 0) {
      return image;
    }

    int oldColor = image[sr][sc];
    dfsFloodFill_recursive(image, sr, sc, oldColor, newColor);

    return image;
  }

  public int[][] floodFill_It(int[][] image, int sr, int sc, int newColor) {
    if (image == null || image.length == 0) {
      return image;
    }

    int oldColor = image[sr][sc];
    dfsFloodFill_iterative(image, sr, sc, oldColor, newColor);

    return image;
  }

  private void dfsFloodFill_iterative(int[][] image, int row, int column, int oldColor, int newColor) {
    LinkedList<Integer> rowsStack = new LinkedList<>();
    LinkedList<Integer> colStack = new LinkedList<>();
    boolean[][] visited = new boolean[image.length][image[0].length];

    rowsStack.appendFirst(row);
    colStack.appendFirst(column);


    while (!rowsStack.isEmpty() && !colStack.isEmpty()) {
      int rowCurrent = rowsStack.getFirst();
      int colCurrent = colStack.getFirst();


      // get the Neighbours in 4 directions
      if(isBoundary(image, rowCurrent, colCurrent, oldColor, newColor) || visited[rowCurrent][colCurrent]) {
        continue;
      }

      image[rowCurrent][colCurrent] = newColor;
      visited[rowCurrent][colCurrent] = true;

      for(int[] direction : DIRECTIONS){
        rowsStack.appendFirst(rowCurrent + direction[0]);
        colStack.appendFirst(colCurrent + direction[1]);
      }
    }



  }

  private void dfsFloodFill_recursive(int[][] image, int row, int column, int oldColor, int newColor) {
    if (isBoundary(image, row, column, oldColor, newColor)) {
      return;
    }

    image[row][column] = newColor;

    for (int[] direction : DIRECTIONS) {
      dfsFloodFill_recursive(image, row + direction[0], column + direction[1], oldColor, newColor);
    }
  }

  private boolean isBoundary(int[][] image, int row, int column, int oldColor, int newColor) {
    // row boundaries
    if (row < 0 || row > image.length - 1) {
      return true;
    }

    // column boundaries
    if (column < 0 || column > image[0].length - 1) {
      return true;
    }

    if(image[row][column] != oldColor) {
      return true;
    }

    if (image[row][column] == newColor) {
      return true;
    }

    return false;
  }

}
