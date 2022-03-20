package mx.com.geekflu.graph.dfs;

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

  public void dfsFloodFill_recursive(int[][] image, int row, int column, int oldColor, int newColor) {
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
    if (column < 0 || column > image[0].length) {
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
