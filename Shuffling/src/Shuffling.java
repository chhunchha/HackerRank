import java.util.Arrays;

/**
 * Created by chhunchha on 10/5/16.
 */
public class Shuffling {

    public static void shuffle(int[] a) {
        int len = a.length;

        for(int i = 0; i < len; i++){
            // pick number between 0 and i
            // don't pick number from 0 to 52 every time - which is not uniformed randomization

            int r = (int) (Math.random() * (i - 1));
            // swap current number which random place
            int temp = a[r];
            a[r] = a[i];
            a[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] cards = new int[52];
        for(int i = 0 ; i < 52; i++) {
            cards[i] = i + 1;
        }
        System.out.println("Sorted Cards: " + Arrays.toString(cards));
        for(int i = 0; i < 10; i++) {
            shuffle(cards);
            System.out.println("Shuffled Cards: " + Arrays.toString(cards));
        }
    }
}
