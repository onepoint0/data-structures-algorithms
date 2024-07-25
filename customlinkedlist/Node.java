package customlinkedlist;

public class Node {
    private int value;
    private Node next;

    public Node() {}

    public Node(int val) {
        this.value = val;
    }

    public Node(int val,Node nextnode) {
        this.value = val;
        this.next = nextnode;
    }

    public void setValue(int val) {
        this.value = val;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public int getValue() {
        return this.value;
    }

    public Node getNext() {
        return next;
    }

}
