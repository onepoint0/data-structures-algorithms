package customlinkedlist;

public class Main {
    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
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
        list1.deleteLast();
        list1.print();
        list1.deleteLast();
        list1.print();


    }
}
