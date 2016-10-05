import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chhunchha on 10/5/16.
 * O(N^2)
 * linear time for partial sorting
 * worst case every element need to be sawpped
 * no swap for sorted array
 */
public class InsertionSort {

    // compare element left to it and swap if it is greater
    // and keep going you find element bigger on left
    // assigning j to current position and checking with j - 1 and keep j moving as as swap element to left
    public static void sort(int[] a) {
        int len = a.length;

        for(int i = 0; i < len; i++) {
            for(int j = i; j > 0; j--){
                if(a[j] < a[j-1]) {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                } else break;
            }
            System.out.println(Arrays.toString(a));
        }
    }
    public static void main(String[] args) {
        int[] a = new int[] {5, 2, 10, 1, 2,5, 7, 4, 9, 3, 6};

        sort(a);
        System.out.println("Sorted: " + Arrays.toString(a));
    }
}
