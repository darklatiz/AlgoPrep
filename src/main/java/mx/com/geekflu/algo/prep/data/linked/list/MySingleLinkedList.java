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
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0) return -1;
        Node current = head;
        int i = 0;
        while (i != index - 1) {
            current = current.next;
            i++;
        }
        return current.val;
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
        Node current = head;

        if (index == this.size) {
            addAtTail(val);
        } else if (index < this.size) {
            while (index - 2 > 0) {
                current = current.next;
                index--;
            }
            Node newNode = new Node(val);
            if (index - 2 == -1) { // head
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = current.next;
                current.next = newNode;
            }
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node current = head;
        int step = 0;
        while (step != index - 2) {
            current = current.next;
            step++;
        }
        current.next = current.next.next;
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