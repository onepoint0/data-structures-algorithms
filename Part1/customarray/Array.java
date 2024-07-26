package customarray;

import java.util.Arrays;

class Array {
    boolean debug = true;
    int[] arr;
    int lastSet = -1;
    int arrIncrease = 50;
    
    Array(int length) {
        arr = new int[length]; 
    }

    void insert(int item) {
        // debug("last set = " + lastSet);
        if (lastSet == arr.length -1) {
            debug("gt.. creating new array");
            int[] tmp = new int[arr.length + arrIncrease];

            System.arraycopy(arr, 0, tmp, 0, arr.length);
            arr = tmp; // print(arr); // this does preserve the remaining zeros
        }
        arr[++lastSet] = item;
    }

    void insertAt(int item,int index) {
        int[] tmp = new int[lastSet+2];
        for (int i = 0; i < tmp.length; i++) {
            if ( i == index) {
                tmp[i] = item;
            } else if (i > index ) {
                tmp[i] = arr[i-1];
            } else {
                tmp[i] = arr[i];
            }
        }
        lastSet++;
        arr = tmp;
    }

    void removeAt(int index) {
        // debug("remove at = " + index);
        if (index > lastSet || index < 0) {
            debug("There is no item at index " + index);
            return;
        }
        for (int i = index; i < lastSet; i++) {
            arr[i] = arr[i+1];
        }
        lastSet--;
        // print(arr);
    }

    int indexOf(int idx) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == idx) {
                return i;
            } 
        }
        return -1;
    }

    int max() {
        return max(arr,lastSet);
    }

    int max(int[] arr2,int limit) {
        int max = 0;
        for (int i = 0; i < limit; i++) {
            max = Math.max(max, arr2[i]);
        }
        return max;
    }

    int[] intersect(int[] arr2) {
        int[] res;
        // we loop through the shorter of the arrays - if it's arr, then only to the lastSet index
        if (arr2.length < lastSet) {
            debug("short array is arr2");
            res = intersect(arr2,arr2.length,arr,lastSet);
        } else {
            debug("short array is arr");
            res = intersect(arr,lastSet,arr2,arr2.length);
        }
        return res;
    }

    boolean inArray(int val,int[] arr, int lim) {
        for (int i = 0; i < lim; i++) {
            if (arr[i] == val) return true;
        }
        return false;
    }

    int[] intersect(int[] shortArray, int shortArrayLimit,int[] longArray, int longArrayLimit) {

        int[] matches = new int[shortArrayLimit];
        int count = 0;

        for (int i = 0; i < shortArrayLimit; i++) {
            // check if in matches first as matches will at the most only ever be as long as the short array, so if there are dupes, discard immediately
            // && / & - handy https://www.oreilly.com/library/view/java-for-dummies/9781118239742/a6_05_9781118239742-ch02.html 
            if (!inArray(shortArray[i], matches, count) && inArray(shortArray[i],longArray,longArrayLimit)) {
                matches[count++] = shortArray[i];
            }
        }

        // get just the ones that have been set from the loop (up to count)
        int[] tmp = new int[count];
        for (int i = 0; i < count; i++) {
            // debug("transferring " + matches[i]);
            tmp[i] = matches[i];
        }
        return tmp;
    }

    void reverse() {
        int[] tmp = new int[lastSet+1];
        for (int i = 0; i <= lastSet; i++) {
            // debug("i = " + i);
            tmp[(i-lastSet)*-1] = arr[i];
        }
        arr = tmp;
    }

    void debug(String message) {
        if (debug) {
            System.out.println(message);            
        }
    }

    void print(int[] inarray) {
        System.err.println(Arrays.toString(inarray));
    }
    void print() {
        for (int i=0; i < lastSet+1; i++ ) {
            System.err.println(arr[i]);
        }
    }
}