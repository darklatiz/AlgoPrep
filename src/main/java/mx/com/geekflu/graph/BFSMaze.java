package mx.com.geekflu.graph;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class BFSMaze {

  private BFSMaze() {}

  private static final int[] VECTOR_ROW_DIRECTION = {-1, 1, 0, 0};
  private static final int[] VECTOR_COL_DIRECTION = {0, 0, 1, -1};

  public static boolean solution(long[][] maze) {
    // Type your solution here

    // Validate edge cases when origin 0,0 == 1, 1 means wall

    if(maze[0][0] == Cell.WALL) {
      printMaze(maze);
      return false;
    }

    LinkedList<Cell> rowQ = new LinkedList<>();

    Cell origin = new Cell(0, 0, maze.length, maze[0].length);
    origin.setDistanceFromOrigin(0);
    rowQ.add(origin);

    while (!rowQ.isEmpty()) {
      Cell current = rowQ.poll();
      current.markAsVisited(maze);


      List<Cell> neighbours = getNeighbours(current, maze);
      rowQ.addAll(neighbours);

      if (current.getRow() == maze.length - 1 && current.getColumn() == maze[0].length - 1) {
        printMaze(maze);
        return true;
      }
    }
    printMaze(maze);
    return false;
  }

  public static void printMaze(long[][] maze) {
    for (long[] row: maze) {
      log.info(Arrays.toString(row));
    }
  }

  public static List<Cell> getNeighbours(Cell cell, long[][] maze) {

    List<Cell> nCells = new ArrayList<>();

    for (int i = 0; i < 4; i++) {
      int neighbourRow = cell.getRow() + VECTOR_ROW_DIRECTION[i];
      int neighbourCol = cell.getColumn() + VECTOR_COL_DIRECTION[i];

      if (neighbourRow < 0 || neighbourCol < 0) {
        continue;
      }

      if (neighbourRow >= cell.getMaxRowsAllowed() || neighbourCol >= cell.getMaxColumsAllowed()) {
        continue;
      }

      //  VISITED
      //  WALL
      if (maze[neighbourRow][neighbourCol] != Cell.VISITED &&
            maze[neighbourRow][neighbourCol] != Cell.WALL) {
        Cell e = new Cell(neighbourRow, neighbourCol, cell.getMaxRowsAllowed(), cell.getMaxColumsAllowed());
        e.setDistanceFromOrigin(cell.getDistanceFromOrigin() + 1);
        nCells.add(e);
      }

    }

    return nCells;
  }

}

@Getter
@Setter
class Cell {

  public static final long VISITED = 2;
  public static final long WALL = 1;

  private int row;
  private int column;
  private boolean isVisited;
  // max rows of MAZE
  private int maxRowsAllowed;
  // Max Cols in the maze
  private int maxColumsAllowed;

  private int distanceFromOrigin;

  public Cell(int row, int col, int maxRows, int maxCols) {
    this.row = row;
    this.column = col;
    //to make it clear
    this.isVisited = false;
    this.maxRowsAllowed = maxRows;
    this.maxColumsAllowed = maxCols;
    this.distanceFromOrigin = 0;
  }

  @Override
  public String toString() {
    return "Cell{" +
      "row=" + row +
      ", column=" + column +
      ", distanceFromOrigin=" + distanceFromOrigin +
      '}';
  }

  public void markAsVisited(long[][] maze) {
    maze[this.row][this.column] = VISITED;
  }
}


