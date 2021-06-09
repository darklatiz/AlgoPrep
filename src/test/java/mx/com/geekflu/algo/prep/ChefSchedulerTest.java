package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.vanhack.ChefScheduler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.*;

@Slf4j
public class ChefSchedulerTest {

  @Test
  public void test_chef_scheduler(){
    HashMap<String, ArrayList<String>> requests = new HashMap<>();
    requests.put(
      "ada", new ArrayList<>(Arrays.asList(
        "mon", "tue", "wed", "fri", "sat", "sun"))
    );
    requests.put(
      "emma", new ArrayList<>(Arrays.asList(
        "tue", "wed", "thu", "sun"))
    );
    requests.put(
      "remy", new ArrayList<>(Arrays.asList(
        "mon", "sat"))
    );
    requests.put(
      "zach", new ArrayList<>(Collections.emptyList())
    );
    assertTrue("it  should work on a basic example.", ChefScheduler.schedulable(requests));

    requests.clear();
    requests.put(
      "emma", new ArrayList<>(Collections.singletonList(
        "sun"))
    );
    requests.put(
      "remy", new ArrayList<>(Collections.singletonList(
        "sun"))
    );
    requests.put(
      "zach", new ArrayList<>(Collections.emptyList())
    );
    assertFalse("it should handle an example where there isn't enough coverage on a day.", ChefScheduler.schedulable(requests));

    requests.clear();
    requests.put(
      "ada", new ArrayList<>(Arrays.asList(
        "mon", "tue", "wed", "thu", "fri", "sat"))
    );
    requests.put(
      "emma", new ArrayList<>(Arrays.asList(
        "tue", "wed", "thu", "sun"))
    );
    requests.put(
      "remy", new ArrayList<>(Arrays.asList(
        "mon", "fri", "sun"))
    );
    requests.put(
      "zach", new ArrayList<>(Collections.emptyList())
    );
    assertFalse("it should handle an example where an employee would need to work in excess of 5 days.", ChefScheduler.schedulable(requests));

  }
}
