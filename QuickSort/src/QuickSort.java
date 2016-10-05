import java.util.Arrays;

/**
 * Created by chhunchha on 10/5/16.
 */
public class QuickSort {

    public static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while(true) {
            while(a[++i] < a[lo]) {
                if(i == hi) break;
            }

            while(a[lo] < a[--j]) {
                if( j == lo) break;
            }

            if( i >= j) break;
            exchange(a, i, j);
        }

        exchange(a, lo, j);
        return j;
    }

    public static void sort(int[] a, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    public static void main(String[] args) {
        int[] a = new int[] {5, 6, 9, 2, 3, 10, 4, 1, 8, 2, 7, 3};
        System.out.println(Arrays.toString(a));
        sort(a, 0, a.length-1);
        System.out.println("Sorted: " + Arrays.toString(a));
    }
}
