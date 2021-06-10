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
  public void test_create_a_list_using_insert_position() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.insert(1, "T");
    Assert.assertFalse(linkedList.isEmpty());
    Assert.assertEquals("T", linkedList.getFirst().getItem());
    Assert.assertTrue("This will be inserted @ first position since list is empty", linkedList.insert(2, "T"));
    linkedList.print();
    Assert.assertTrue(linkedList.insert(3, "a")); // insert @ the end
    linkedList.print();
    Assert.assertTrue(linkedList.insert(1, "b")); // insert @ the end
    Assert.assertEquals(3, linkedList.size());
    linkedList.print();
    Assert.assertTrue(linkedList.insert(1, "M")); // insert @ the end
    linkedList.print();
    linkedList.print(Direction.TAIL2HEAD);
  }

  @Test
  public void test_is_empty_clear() {
    LinkedList<Integer> integerLinkedList = new LinkedList<>();
    Assert.assertEquals(0, integerLinkedList.size());
    Assert.assertTrue(integerLinkedList.isEmpty());
    integerLinkedList.clear();
  }
}
