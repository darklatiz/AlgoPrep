package mx.com.geekflu.algo.prep.data.linked.list.domain;


public class Node {
    public Node next;
    public int val;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }
}

