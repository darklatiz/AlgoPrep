package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.stack.BalanceBrackets;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class BalanceBracketsTest {

  @Test
  public void test_is_balanced_angle_brackets() {
    Assert.assertTrue(BalanceBrackets.isBalance("<<>><><><<<>>>"));
    Assert.assertFalse(BalanceBrackets.isBalance("<<>><><><<<>"));
    Assert.assertTrue(BalanceBrackets.isBalance("<[{()}]><><><>()"));
  }

}
