package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.ifc.Direction;
import mx.com.geekflu.algo.prep.data.linked.list.LinkedList;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class LinkedListTest {

  @Test
  public void create_link_list() {
    LinkedList<String> myStringLinkedList = new LinkedList<>();
    Assert.assertEquals(0, myStringLinkedList.size());

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

    myStringLinkedList.clear();
    Assert.assertEquals(0, myStringLinkedList.size());
  }



}
