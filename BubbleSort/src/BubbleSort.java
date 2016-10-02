/**
 * Created by chhunchha on 9/30/16.
 */
public class BubbleSort {

    public static int[] sort(int[] arr) {
        boolean isSorted = false;
        int tillIndex = arr.length - 1;
        int swapCount = 0;
        while(!isSorted) {
            isSorted = true;
            for(int i = 0; i < tillIndex ; i++) {
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                    isSorted = false;
                    swapCount++;
                }
            }
            tillIndex--;
        }
        System.out.println("Array is sorted in " +  swapCount + " swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[arr.length - 1]);
        return arr;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3};
        sort(a);

        a = new int[] { 3, 2, 1};
        sort(a);
    }
}
