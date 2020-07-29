package mx.com.geekflu.algo.prep.data.linked.list;

import mx.com.geekflu.algo.prep.data.linked.list.domain.Node;

public class MySingleLinkedList {

    private Node head;
    private int size;

    public MySingleLinkedList() {

    }

    public static void main(String[] args) {
        MySingleLinkedList mySingleLinkedList = new MySingleLinkedList();
        mySingleLinkedList.addAtHead(10);
        mySingleLinkedList.print();

        mySingleLinkedList.addAtHead(20);
        mySingleLinkedList.print();

        mySingleLinkedList.addAtHead(100);
        mySingleLinkedList.print();

        mySingleLinkedList.addAtHead(155);
        mySingleLinkedList.print();

        mySingleLinkedList.addAtIndex(2, 55050);
        mySingleLinkedList.print();

        mySingleLinkedList.addAtIndex(1, 1);
        mySingleLinkedList.print();

        mySingleLinkedList.addAtIndex(10, -1010); //not inserted
        mySingleLinkedList.print();

        mySingleLinkedList.addAtIndex(6, -1010);
        mySingleLinkedList.print();

        mySingleLinkedList.addAtIndex(4, -2020);
        mySingleLinkedList.print();

        System.out.println(mySingleLinkedList.get(4));
        mySingleLinkedList.deleteAtIndex(4);
        mySingleLinkedList.print();

        System.out.println(mySingleLinkedList.get(4));

        MySingleLinkedList linkedList = new MySingleLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.print();
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        linkedList.print();
        System.out.println(linkedList.get(1));            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        linkedList.print();
        System.out.println(linkedList.get(1));

        System.out.println("_____________________________________________");
        MySingleLinkedList linkedList1 = new MySingleLinkedList();
        linkedList1.addAtHead(1);
        linkedList1.print();

        linkedList1.addAtTail(3);
        linkedList1.print();

        linkedList1.addAtIndex(1, 2);
        linkedList1.print();
        System.out.println(linkedList1.get(1));

        linkedList1.deleteAtIndex(0);
        linkedList1.print();
        System.out.println(linkedList1.get(0));

        System.out.println("_____________________________________________");
        MySingleLinkedList linkedList2 = new MySingleLinkedList();
        linkedList2.addAtIndex(0, 10);
        linkedList2.print();
        linkedList2.addAtIndex(0, 20);
        linkedList2.print();
        linkedList2.addAtIndex(1, 30);
        linkedList2.print();
        System.out.println(linkedList2.get(0));

        System.out.println("_____________________________________________");
        MySingleLinkedList linkedList3 = new MySingleLinkedList();
        linkedList3.addAtHead(9);
        System.out.println(linkedList3.get(1));
        linkedList3.addAtIndex(1, 1);
        linkedList3.addAtIndex(1, 7);
        linkedList3.print();
        linkedList3.deleteAtIndex(1);
        linkedList3.print();
        linkedList3.addAtHead(7);
        linkedList3.print();
        linkedList3.addAtHead(4);
        linkedList3.print();
        linkedList3.deleteAtIndex(1);
        linkedList3.print();
        linkedList3.addAtIndex(1, 4);
        linkedList3.print();
        linkedList3.addAtHead(2);
        linkedList3.print();
        linkedList3.deleteAtIndex(5);
        linkedList3.print();


    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index > size - 1) return -1;
        Node current = head;
        int i = 0;
        while (i != index) {
            current = current.next;
            i++;
        }
        return current.val;
    }

    public Node getAtIndex(int index) {
        if (index < 0 || index > size - 1) return null;
        Node current = head;
        int i = 0;
        while (i != index) {
            current = current.next;
            i++;
        }
        return current;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (this.head == null) {
            this.head = new Node(val);
            size++;
            return;
        }
        Node n = new Node(val);
        n.next = head;
        this.head = n;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node n = new Node(val);
        current.next = n;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (head == null) {
            Node n = new Node(val);
            this.head = n;
            size++;
            return;
        }
        if (index == this.size) {
            addAtTail(val);
        } else if (index < this.size) {
            Node current = getAtIndex(index - 1); //we stand before the actual node
            Node newNode = new Node(val);
            if (index - 1 == -1) { // head
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = current.next;
                current.next = newNode;
            }
            size++;
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            Node current = getAtIndex(index - 1); // before the actual node to delete
            if (index - 1 == -1) { // head
                head = head.next;
            } else {
                current.next = current.next.next;
            }
            size--;
        }
    }

    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public void print() {
        Node current = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (current != null) {
            stringBuilder.append(current.val);
            stringBuilder.append(" -> ");
            current = current.next;
        }
        System.out.println(stringBuilder.toString());
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */