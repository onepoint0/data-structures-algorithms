package customarray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(35);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insert(35);
        numbers.print();
        numbers.removeAt(1);
        System.out.println("max = " + numbers.max());
        System.out.println("index of = " + numbers.indexOf(35));
        System.out.println("Calling intersect, arr curr = ");
        numbers.print();
        int[] arr = {10,30,30};
        System.out.println(Arrays.toString(numbers.intersect(arr)));
        numbers.reverse();
        System.out.println("After reverse, array = ");
        numbers.print();
        System.out.println("calling insert \"100\" at index \"3\"...");
        numbers.insertAt(100, 3);
        numbers.print();
    }
}
