package mx.com.geekflu.algo.prep.puzzlez;

import java.util.Random;

/**
 * Implement the maze as a two-dimensional array of integers. 
 * If the value of an element is 1, it is a wall. If the value is 0, it is a pass.
 * 1. There should be walls around the maze, with the exception of two cells - entrance and exit.
 * 
 * 2. Any empty cell must be accessible from the entrance or exit of the maze. 
 * It is not possible to walk along the maze diagonally, only vertically and horizontally.
 * 
 * 3. There's got to be a path from the entrance to the exit. 
 * It doesn't matter what is considered an entrance and what is an exit as they are interchangeable.
 * 
 * To print the array, follow these two rules:
 * to display a pass, use two space characters
 * to display a wall, use two block characters in a row (the same): █ (U+2588). 
 * You can print the wall like this: System.out.print("\u2588\u2588").
 * Remember that the maze is only visible if you have a monospace font! Otherwise, 
 * the space symbol will be quite small in width. 
 * At this stage, it does not matter which maze you display. 
 * The program may always output the same prepared maze or one of a set of prepared mazes.
 * @author vn04q89
 *
 */
public class MazeGenerator {
	
	private static final String PASS = "  ";
	
	private static int[][] maze = {
			{1,0,1,1,1,1,1,1,1},
			{1,0,1,0,0,0,0,1,1},
			{1,0,0,1,1,1,0,0,1},
			{1,1,0,1,0,0,0,0,1},
			{1,1,0,1,0,1,1,0,1},
			{1,0,0,0,0,1,1,0,1},
			{1,1,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,1,0},
			{1,1,1,1,1,1,1,1,1},
	};
	
	int[] numbers = {1,2,3,4,5,6,7,8,9,10};

	public static void main(String[] args) {
		for(int i = 0 ; i < maze.length ; i++) {
			for(int j = 0 ; j < maze.length ; j++) {
				if(maze[i][j] == 0) {
					System.out.print("  ");
				}else if(maze[i][j] == 1) {
					System.out.print("\u2588\u2588");
				}
			}
			System.out.println("");
		}
		MazeGenerator m = new MazeGenerator();
		System.out.println(m.method(m.numbers, 0, 9));
		m.test(100);
    }
	
	
	public int method(int[] arr, int left, int right) {
		System.out.println("Left: "+ left);
		System.out.println("Right: "+ right);
		if( left == right) {
			return arr[left] % 2 == 0 ? 1:0;
		}else {		
			int mid = (left + right) / 2;
			return method(arr, left, mid) + method(arr, mid +1, right);
		}
	}
	
	public void test(int n) {
		if(n > 0) {
			System.out.println(n);
			test(n-1);
		}
	}
	
}
