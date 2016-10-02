import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chhunchha on 10/1/16.
 */
public class MakeChange {

    public static void print_change(int coins[], int[] which_coin_used) {
        List<Integer> change = new ArrayList<>();
        int j = which_coin_used.length - 1;
        while(which_coin_used[j] != -1) {
            int coin = coins[which_coin_used[j]];
            change.add(coin);
            j = j - coin;
        }

        System.out.println(change.toString());
    }

    public static void makeChange(int coins[], int money) {
        int[] how_many_coins_used = new int[money+1];
        int[] which_coin_used = new int[money+1];

        for(int i = 0; i <= money; i++) {
            how_many_coins_used[i] = Integer.MAX_VALUE - 1;
            which_coin_used[i] = -1;
        }

        how_many_coins_used[0] = 0;

        for(int c = 0; c < coins.length; c++) {
            for(int j = coins[c]; j <= money; j++) {
                if(j == coins[c]) {
                    how_many_coins_used[j] = 1;
                    which_coin_used[j] = c;
                } else if( j - coins[c] >= 0 && how_many_coins_used[j - coins[c]] != Integer.MAX_VALUE - 1) {
                    how_many_coins_used[j] = 1 + how_many_coins_used[j - coins[c]];
                    which_coin_used[j] = c;
                }
            }
//            System.out.println(Arrays.toString(how_many_coins_used));
//            System.out.println(Arrays.toString(which_coin_used));
            System.out.println("Change combo: ");
            print_change(coins, which_coin_used);
            System.out.println();
        }
    }

    public static void makeChangeWithMinCoins(int coins[], int money) {
        int[] how_many_coins_used = new int[money+1];
        int[] which_coin_used = new int[money+1];

        for(int i = 0; i <= money; i++) {
            how_many_coins_used[i] = Integer.MAX_VALUE - 1;
            which_coin_used[i] = -1;
        }

        how_many_coins_used[0] = 0;

        for(int c = 0; c < coins.length; c++) {
            for(int j = coins[c]; j <= money; j++) {
                if(j == coins[c]) {
                    how_many_coins_used[j] = 1;
                    which_coin_used[j] = c;
                } else if( j - coins[c] >= 0 && how_many_coins_used[j] > 1 + how_many_coins_used[j - coins[c]]) {
                    how_many_coins_used[j] = 1 + how_many_coins_used[j - coins[c]];
                    which_coin_used[j] = c;
                }
            }
//            System.out.println(Arrays.toString(how_many_coins_used));
//            System.out.println(Arrays.toString(which_coin_used));
//            System.out.println();
        }
        System.out.println("Change with min coins : ");
        print_change(coins, which_coin_used);
    }

    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int money = 10;

        System.out.println("Coins: " + Arrays.toString(coins));
        System.out.println("Total: " + money);
        System.out.println();
        makeChange(coins, money);
        makeChangeWithMinCoins(coins, money);
    }
}
