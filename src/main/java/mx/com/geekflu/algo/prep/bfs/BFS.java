package mx.com.geekflu.algo.prep.bfs;

import mx.com.geekflu.algo.prep.data.structures.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BFS<T> {

  public int baseTemplateBFS(Node root, Node target){
    Queue<Node<T>> queue = new LinkedList<>(); // this is to store all the node waiting to be processed
    Set<Node<T>> visited = new HashSet<>(); // store all the nodes that we have visited
    int step = 0; //  Number of steps needed from root to current node

    //initialize
    queue.add(root);
    visited.add(root);

    while(queue.size() > 0){
      step += 1;
      for(int i = 0; i < queue.size(); ++i){
        Node current = queue.peek();
        if(current.getData().equals(target.getData())){
          return step;
        }
        //we should iterate over the neighbors of current node
          //if the neighbor is not visited
            //add neighbor to the queue
            //add neighbor to the visited
          queue.remove();
      }
    }
    return 0;
  }

  public int dfsIslands(char[][] grid){
    if(grid == null || grid.length == 0 ){
      return 0;
    }
    Stack<Cell> stack = new Stack<>();
    int numIslands = 0;
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];

    for(int row = 0; row < m; row++){
      for (int col = 0; col < n; col++){
        char current = grid[row][col];
        if(current == '1' && !visited[row][col]){
          stack.push(new Cell(row, col));
          visited[row][col] = true;
          numIslands++;
          while(!stack.empty()){
            Cell celda = stack.pop();
            int r = celda.row;
            int c = celda.col;
            if(r>0 && grid[r-1][c]=='1' && !visited[r-1][c]){
              stack.push(new Cell(r-1,c));
              visited[r-1][c] = true;
            }
            if(c>0 && grid[r][c-1]=='1' && !visited[r][c-1]){
              stack.push(new Cell(r,c-1));
              visited[r][c-1] = true;
            }
            if(r<m-1 && grid[r+1][c]=='1' && !visited[r+1][c]){
              stack.push(new Cell(r+1,c));
              visited[r+1][c] = true;
            }
            if(c<n-1 && grid[r][c+1]=='1' && !visited[r][c+1]){
              stack.push(new Cell(r,c+1));
              visited[r][c+1] = true;
            }
          }
        }
      }
    }
    return numIslands;
  }

  public int numOfIslands_DFS(char[][] grid){
    if(grid == null || grid.length <= 0){
      return 0;
    }
    int numIslands = 0;
    for(int row = 0; row < grid.length; row++){
      for(int col = 0; col < grid[row].length; col++){
        if(grid[row][col] == '1'){
          numIslands++;
          dfs(grid, row, col);
        }
      }
    }
    return numIslands;
  }

  public int bfs(char[][] grid, int row, int col){
    if(grid == null || grid.length <= 0) {
      return 0;
    }

    return 0;
  }

  void dfs(char[][] grid, int row, int col) {
    int nr = grid.length;
    int nc = grid[0].length;

    if (row < 0 || col < 0 || row >= nr || col >= nc || grid[row][col] == '0') {
      return;
    }

    grid[row][col] = '0';
    dfs(grid, row - 1, col);
    dfs(grid, row + 1, col);
    dfs(grid, row, col - 1);
    dfs(grid, row, col + 1);
  }

  public static void main(String[] args) {

    char[][] characters = {
      {'1', '1', '0', '0', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '1', '0', '0'},
      {'0', '0', '0', '1', '1'},
      {'1', '1', '0', '0', '0'}
    };

    char[][] characters1 = {
      {'1', '1', '1', '0', '0'},
      {'1', '0', '1', '0', '0'},
      {'0', '1', '1', '0', '0'},
      {'0', '1', '1', '1', '1'},
      {'1', '1', '0', '0', '1'}
    };

    BFS<Character> bfs = new BFS<>();
    System.out.println(bfs.numOfIslands_DFS(characters));
    System.out.println(bfs.numOfIslands_DFS(characters1));
  }
}
class Cell{
  public int row;
  public int col;
  public Cell(int r, int c){
    this.row = r;
    this.col = c;
  }
}