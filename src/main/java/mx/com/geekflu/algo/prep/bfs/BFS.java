package mx.com.geekflu.algo.prep.bfs;

import mx.com.geekflu.algo.prep.data.structures.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

  public int numOfIslands(char[][] grid){
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

  void bfs(char[][] grid, int row, int col){

    return;
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

    BFS<Character> bfs = new BFS<>();

  }


}
