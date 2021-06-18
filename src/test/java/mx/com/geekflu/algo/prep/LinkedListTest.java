package mx.com.geekflu.algo.prep;

import lombok.extern.slf4j.Slf4j;
import mx.com.geekflu.algo.prep.data.core.ifc.Direction;
import mx.com.geekflu.algo.prep.data.linked.list.LinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    Assert.assertEquals("T", linkedList.getFirst());
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

  @Test
  public void test_contains() {
    LinkedList<String> linkedList = new LinkedList<>();

    Assert.assertFalse(linkedList.contains("a"));

    linkedList.appendFirst("a");
    linkedList.appendFirst("b");
    linkedList.appendFirst("c");
    linkedList.append("zzzz");
    linkedList.print();

    Assert.assertTrue(linkedList.contains("zzzz"));

    Assert.assertFalse(linkedList.contains("zzzzA"));

    Assert.assertFalse(linkedList.contains(null));

    Assert.assertTrue(linkedList.containsAll(List.of("zzzz", "c", "b", "a")));
    Assert.assertTrue(linkedList.containsAll(List.of("c", "b", "a")));
    Assert.assertTrue(linkedList.containsAll(List.of("c", "b")));
    Assert.assertTrue(linkedList.containsAll(List.of("c")));
    Assert.assertFalse(linkedList.containsAll(List.of("cs")));
    Assert.assertFalse(linkedList.containsAll(List.of("c", "bs", "a")));
    Assert.assertFalse(linkedList.containsAll(List.of("NOT_found")));
    Assert.assertFalse(linkedList.containsAll(new ArrayList<>()));
  }

  @Test
  public void test_remove() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    Assert.assertFalse(linkedList.remove(null));
    Assert.assertFalse(linkedList.remove(1));

    linkedList.appendFirst(1);
    linkedList.append(2);
    linkedList.append(3);
    linkedList.append(4);
    Assert.assertTrue(linkedList.remove(1));
    Assert.assertTrue(linkedList.remove(2));
    Assert.assertTrue(linkedList.remove(3));
    Assert.assertTrue(linkedList.remove(4));
    Assert.assertFalse(linkedList.remove(5));

    linkedList.appendFirst(1);
    linkedList.append(2);
    linkedList.append(2);
    linkedList.append(3);
    linkedList.append(3);
    linkedList.append(4);
    linkedList.append(4);

    Assert.assertTrue(linkedList.remove(4));
    linkedList.print();

    Assert.assertTrue(linkedList.remove(1));
    linkedList.print();

    Assert.assertTrue(linkedList.remove(3));
    linkedList.print();

    Assert.assertTrue(linkedList.remove(2));
    linkedList.print();

    Assert.assertTrue(linkedList.remove(2));
    linkedList.print();

    Assert.assertTrue(linkedList.remove(3));
    linkedList.print();

    Assert.assertTrue(linkedList.contains(4));
    Assert.assertEquals(1, linkedList.size());

  }

  @Test
  public void  test_get_data() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.append("a");
    linkedList.append("b");
    linkedList.append("c");
    linkedList.appendFirst("3");
    linkedList.appendFirst("2");
    linkedList.appendFirst("1");
    linkedList.print();

    Assert.assertEquals("1", linkedList.getFirst());
    linkedList.print();
    Assert.assertEquals("c", linkedList.getLast());
    linkedList.print();

    Assert.assertEquals("2", linkedList.getFirst());
    linkedList.print();
    Assert.assertEquals("b", linkedList.getLast());
    linkedList.print();

    Assert.assertEquals("3", linkedList.getFirst());
    linkedList.print();
    Assert.assertEquals("a", linkedList.getLast());
    linkedList.print();

    Assert.assertNull(linkedList.getFirst());
    Assert.assertNull(linkedList.getLast());
  }
}
