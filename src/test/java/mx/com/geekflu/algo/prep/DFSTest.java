package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.graph.dfs.FloodFill;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class DFSTest {

  @Test
  public void test_flood_fill_recursive(){
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
  @Test
  public void test_flood_fill_oterative(){
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

    int[][] image02= {
      {0, 0, 0},
      {0, 0, 0}
    };



    FloodFill floodFill = new FloodFill();
    floodFill.floodFill_It(image, 1, 1, 2);
    Arrays.stream(image)
      .forEach(row -> log.info(Arrays.toString(row)));

    log.info("\n");

    floodFill.floodFill_It(image01, 1, 3, 4);
    Arrays.stream(image01)
      .forEach(row -> log.info(Arrays.toString(row)));

    log.info("\n");

    floodFill.floodFill_It(image02, 0, 0, 2);
    Arrays.stream(image02)
      .forEach(row -> log.info(Arrays.toString(row)));

  }


}
