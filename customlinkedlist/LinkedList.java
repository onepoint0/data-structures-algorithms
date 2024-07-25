package customlinkedlist;

public class LinkedList {
    private Node first;
    private Node last;

    // addFirst 
    // addLast
    // deleteFirst
    // deleteLast
    // contains
    // indexOf

    LinkedList() {
        // first = new Node();
        // last = new Node();
    }

    private void delete() {
        first.setNext(null);
        last.setNext(null);
        first = last = null;
    }

    public void addFirst(int val) {
        System.out.println("ADD FIRST " +  val);
        // var node = new Node(val);
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
        int i = 0;
        while (curr.getNext() != null) {
            curr = curr.getNext();
            i++; if (i > 300) { System.out.println("breaking over 300"); break;  }
        }
        System.out.println("GET SECOND LAST val = " + curr.getValue());
        return curr;
    }

    public void deleteFirst() {
        System.out.println("DELETE FIRST");
        if (first == last) {
            delete();
        } else {
            var next = first.getNext();
            first.setNext(null); // set to null so that it gets garbage collected
            first = next;
        }
    }

    public void deleteLast() {
        System.out.println("DELETE LAST");
        if (first == last) {
            delete();
        } else {
            // last.setNext(null); // for garbage collection
            // last = getSecondLast();
            // last.setNext(null);
        }
    }

    public boolean contains(int val) {
        System.out.println("CONTAINS " + val);
        boolean contains = false;

        if ( first != null ) {

//            int loops = 0;
            Node currNode = first;
            while (currNode.getNext() != null) {
                // System.out.println("curr node value " + currNode.getValue());

                if (currNode.getValue() == val) {
                    contains = true;
                    break;
                }
                currNode = currNode.getNext();

//                loops++; if (loops > 200) { System.out.println("loops > 4, breaking"); break; }
            } 
        } 
        if (contains) {
            System.out.println("Linked list contains " + val);
        } else {
            System.out.println("Linked list does NOT contain " + val);
        }
        return contains;
    }

    public int indexOf(int val) {
        System.out.println("INDEX OF " + val);
        int idx = -1;
        int loops = 0;

        if (first != null ) {
            Node currNode = first;
            while (currNode.getNext() != null) {
                if (currNode.getValue() == val) {
                    idx = loops;
                    break;
                }
                currNode = currNode.getNext();

                loops++; if (loops > 200) { System.out.println("loops > 4, breaking"); break; }
            } 
        } 
        System.out.println("Index of " + val + " is " + idx);
        return idx;
    }

    public void print() {
        if (first != null ) {

            int loops = 0;
            Node currNode = first;
            String tostr = new String();
            while (currNode.getNext() != null) {
                // System.out.println("curr node value " + currNode.getValue());
                tostr = tostr + currNode.getValue() + ", ";
                // System.out.println("curr string = " +  tostr);
                currNode = currNode.getNext();

                loops++; if (loops > 200) { System.out.println("loops > 4, breaking"); break; }
            } 
            System.out.println("complete output is " + "[" + tostr + currNode.getValue() + "]");
        } else {
            System.out.println("List is currently EMPTY");
        }
    }

}
