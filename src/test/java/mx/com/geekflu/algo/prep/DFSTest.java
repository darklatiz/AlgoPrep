package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.graph.dfs.FloodFill;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class DFSTest {

  @Test
  public void test_flood_fill(){
    int[][] image = {
      {1, 1, 1},
      {1, 1, 0},
      {1, 0, 1}
    };

    int[][] image01 = {
      {1, 1, 1, 1, 0, 1, 1, 1},
      {1, 1, 0, 1, 1, 1, 0, 1},
      {1, 0, 1, 0, 1, 0, 1, 1}
    };

    FloodFill floodFill = new FloodFill();
    floodFill.floodFill(image, 1, 1, 2);
    Arrays.stream(image)
      .forEach(row -> log.info(Arrays.toString(row)));

    floodFill.floodFill(image01, 1, 3, 4);
    Arrays.stream(image01)
      .forEach(row -> log.info(Arrays.toString(row)));

  }

}
