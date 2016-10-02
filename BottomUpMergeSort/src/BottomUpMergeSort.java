import java.util.Arrays;

/**
 * Created by chhunchha on 9/30/16.
 */
public class BottomUpMergeSort {

    public static int[] aux;

    public static boolean less(int a, int b) {
        return a < b;
    }

    public static void merge(int[] arr, int lo, int mid, int hi) {
        System.out.println( "lo " + lo + ", mid " + mid + ", hi " + hi);
        System.out.println("arr " + Arrays.toString(arr));
        for(int k = lo; k <= hi; k++)
            aux[k] = arr[k];

        System.out.println("aux " + Arrays.toString(aux));

        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            if(i > mid)                     arr[k] = aux[j++];
            else if(j > hi)                 arr[k] = aux[i++];
            else if(less(aux[j], aux[i]))   arr[k] = aux[j++];
            else                            arr[k] = aux[i++];

            System.out.println("arr " + Arrays.toString(arr));
        }
        System.out.println();
    }

    public static int[] sort(int[] arr) {

        int len = arr.length;

        for(int sz = 1; sz < len ; sz += sz) {

            //start from 0 and increases double of size till len - sz as last portion gets sent to merge
            for(int lo = 0 ; lo < len - sz; lo += sz+sz) {

                //in case of odd number we might end up at end where we not have enough sub array numbers
                // merging [1 2][3 4] [5 6][7]
                merge(arr, lo, lo+sz-1, Math.min(lo+sz+sz-1, len -1));

            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 10, 21, 2, 3, 7, 1, 2, 8};
        aux = new int[arr.length];

        int[] sorted_arr = sort(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }
}
