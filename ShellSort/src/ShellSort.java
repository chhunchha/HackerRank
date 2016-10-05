import java.util.Arrays;

/**
 * Created by chhunchha on 10/5/16.
 */
public class ShellSort {

    // get h-sorted
    // rather than going back 1 left, we go h left to get h sorted array
    // and then do insertion sort on h sort
    // 7 -sort then 3-sort then 1-sort (insertion)
    public static void sort(String[] a) {
        int len = a.length;

        //better one is
        //sedgewick [1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905,...]
        //or 3x + 1 = [1, 4, 13, 40, 121, 364, ...]
        int h = 1;
        while(h < len/3) h = 3 * h + 1;

        while(h >= 1) {
            for(int i = h; i < len; i++){
                for(int j = i; j >= h && (a[j].compareTo(a[j-1]) < 0); j-= h) {
                    String temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
                System.out.println(Arrays.toString(a));
            }
            h = h / 3;
            System.out.println(Arrays.toString(a));
        }

    }
    public static void main(String[] args) {
        String[] a = new String[] { "S", "H", "E", "E", "L", "S", "O", "R", "T"};
        sort(a);
        System.out.println("Sorted: " + Arrays.toString(a));
    }
}
