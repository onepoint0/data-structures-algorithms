package customlinkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;

    // addFirst 
    // addLast
    // deleteFirst
    // deleteLast
    // contains
    // indexOf

    private void delete() {
        first.setNext(null);
        last.setNext(null);
        first = last = null;
    }

    public void addFirst(int val) {
        System.out.println("ADD FIRST " +  val);
        if (first == null) 
            first = last = new Node(val);
        else 
            first = new Node(val,first);
    }

    public void addLast(int val) {
        System.out.println("ADD LAST " + val);
        if (first == null)
            first = last = new Node(val);
        else {
            last.setNext(new Node(val));
            last = last.getNext();
        }

    }

    public Node getSecondLast() {
        Node curr = first;
        // int i = 0;
        while (curr.getNext().getNext() != null) {
            curr = curr.getNext();
            // printNode(curr)
            // i++; if (i > 2000) { System.out.println("INFINITE LOOP!! breaking..."); break;  }
        }
        System.out.println("GET SECOND LAST val = " + curr.getValue());
        return curr;
    }

    public void deleteFirst() {
        System.out.println("DELETE FIRST");
        if (first == last) {
            delete();
        } else {
            var next = first.getNext(); // keep a reference to the 2nd element so we can remove next link from first w/o losing ref to the head of the list
            first.setNext(null); // set to null so that it gets garbage collected
            first = next;
        }
    }

    public void deleteLast() {
        System.out.println("DELETE LAST");
        if (first == last) {
            delete();
        } else {
            var penultimate = getSecondLast();
            penultimate.setNext(null);
            last.setNext(null); // for garbage collection
            last = penultimate;
        }
    }

    public int indexOf(int val) {
        System.out.println("INDEX of " + val);

        int idx = 0;
        if ( first != null ) {

            Node currNode = first;
            while (currNode != null) {

                if (currNode.getValue() == val) {
                    System.out.println("index of " + val + " is " + idx);
                    return idx;
                }
                currNode = currNode.getNext();
                idx++;
                // if (idx > 2000) { System.out.println("INFINITE LOOP!! breaking..."); break; }
            }
        } 

        System.out.println("index of " + val + " is " + -1);
        return -1;
    }

    public Boolean contains(int val) {
        System.out.println("CONTAINS " + val);

        if (indexOf(val) > -1 ) {
            System.out.println("List does contain " + val);
            return true;
        }
        System.out.println("List does NOT contain " + val);
        return false;
    }

    private void printNode(Node node) {
        System.out.println("Node is " +  node + ", val " + node.getValue() + ", next " + node.getNext());
    }

    public void print() {
        if (first != null ) {

            int loops = 0;
            Node currNode = first;
            String tostr = new String();
            while (currNode.getNext() != null) {
                tostr = tostr + currNode.getValue() + ", ";
                currNode = currNode.getNext();

                loops++; if (loops > 200) { System.out.println("loops > 4, breaking"); break; }
            } 
            System.out.println("complete output is " + "[" + tostr + currNode.getValue() + "]");
        } else {
            System.out.println("List is currently EMPTY");
        }
    }

}
