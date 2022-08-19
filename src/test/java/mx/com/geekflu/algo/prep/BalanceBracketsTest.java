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
    Assert.assertTrue(BalanceBrackets.isBalance("(<[{()}]><><><>())"));
  }

  @Test
  public void test_balancing_bracket_string() {
    String balancedStr = BalanceBrackets.balanceBrackets("><>><");
    Assert.assertTrue(BalanceBrackets.isBalance(balancedStr));

    balancedStr = BalanceBrackets.balanceBrackets("><><<><>>>><><<<>><<");
    log.info("Trying to balance: ><><<><>>>><><<<>><<, the result after balancing is: {}", balancedStr);
    Assert.assertTrue(BalanceBrackets.isBalance(balancedStr));

    balancedStr = BalanceBrackets.balanceBrackets(">");
    log.info("Trying to balance: >, the result after balancing is: {}", balancedStr);
    Assert.assertTrue(BalanceBrackets.isBalance(balancedStr));

    balancedStr = BalanceBrackets.balanceBrackets("<");
    log.info("Trying to balance: <, the result after balancing is: {}", balancedStr);
    Assert.assertTrue(BalanceBrackets.isBalance(balancedStr));

    balancedStr = BalanceBrackets.balanceBrackets("");
    log.info("Trying to balance: '', the result after balancing is: {}", balancedStr);
    Assert.assertTrue(BalanceBrackets.isBalance(balancedStr));
  }

}
