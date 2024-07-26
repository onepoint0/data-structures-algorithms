package customlinkedlist;

public class Main {
    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
        list1.indexOf(0);
        list1.addLast(1);
        list1.print();
        list1.addLast(2);
        list1.print();
        list1.addFirst(30);
        list1.print();
        list1.addFirst(10);
        list1.print();
        list1.addLast(3);
        list1.print();
        list1.addFirst(20);
        list1.print();
        list1.deleteFirst();
        list1.print();
        list1.deleteFirst();
        list1.print();
        list1.contains(1);
        list1.contains(300);
        list1.indexOf(3);
        list1.indexOf(10);
    }
}
