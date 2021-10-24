package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.graph.BFSMaze;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class BFSTest {

  @Test
  public void test_bfs_maze_simple() {
    long[][] maze1 = {
      {1, 1},
      {0, 0}
    };

    long[][] maze2 = {
      {0, 1},
      {0, 0}
    };

    long[][] maze3 = {
      {0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
      {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
      {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
      {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
      {1, 0, 1, 1, 1, 1, 0, 0, 0, 0},
      {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
      {1, 0, 1, 1, 1, 1, 0, 0, 1, 1},
      {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    long[][] maze4 = {
      {0, 1},
      {0, 0}
    };

    Assert.assertFalse(BFSMaze.solution(maze1));
    Assert.assertTrue(BFSMaze.solution(maze2));
    Assert.assertTrue(BFSMaze.solution(maze3));

  }

}
