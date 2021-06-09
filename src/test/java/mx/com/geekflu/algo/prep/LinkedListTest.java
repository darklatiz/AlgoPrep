package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.ifc.Direction;
import mx.com.geekflu.algo.prep.data.linked.list.LinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class LinkedListTest {

  @Test
  public void create_link_list() {
    LinkedList<String> myStringLinkedList = new LinkedList<>();

    myStringLinkedList.appendFirst("h");
    myStringLinkedList.appendFirst("0");
    myStringLinkedList.appendFirst("l");
    myStringLinkedList.appendFirst("a");

    myStringLinkedList.appendFirst("M");
    myStringLinkedList.appendFirst("u");
    myStringLinkedList.appendFirst("n");
    myStringLinkedList.appendFirst("d");
    myStringLinkedList.appendFirst("o");
    myStringLinkedList.appendFirst("!");

    myStringLinkedList.print(Direction.HEAD2TAIL);
    myStringLinkedList.print(Direction.TAIL2HEAD);

    Assert.assertEquals(10, myStringLinkedList.size());

  }

  @Test
  public void test_is_empty_clear() {
    LinkedList<Integer> integerLinkedList = new LinkedList<>();

    Assert.assertEquals(0, integerLinkedList.size());
    Assert.assertTrue(integerLinkedList.isEmpty());

    integerLinkedList.clear();

    List<String> days = Arrays.asList("m", "h", "j");
    Map<String, Boolean> test = days.stream().collect(Collectors.toMap(s -> s, v -> Boolean.TRUE));
    if(test.get("y"))
      log.info("WHAT");
    test.isEmpty();
    test.size();
  }



}
