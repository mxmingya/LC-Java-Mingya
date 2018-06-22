package DP;
import java.util.*;
/**
 * Created by mingyama on 9/16/17.
 */
public class CoinChange {
    public int coinChange_recursion(int[] coins, int amount) {
        int[] money = new int[amount];
        return helper(coins, amount, money);
    }
    private int helper(int[] coins, int amount, int[] money) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (money[amount-1] != 0) return money[amount-1];
        int minCount = Integer.MAX_VALUE;
        for (int i = coins.length-1; i >= 0; i--) {
            int res = helper(coins, amount-coins[i], money);
            if (res >= 0 && res < minCount) {
                minCount = res + 1;
            }
        }
        money[amount-1] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return money[amount-1];
    }


    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        for (int i = 1; i < amount+1; i++) {
            int curMin =-1;
            for (int coin : coins) {
                if (i < coin) break;
                // find the min among all dp[i-coin]
                int preMin = dp[i-coin]+1;
                curMin = curMin == -1 ? preMin : Math.min(preMin, curMin);
            }
            dp[i] = curMin;
        }
        int count = 0;
        for (int i : dp) {

            System.out.printf("%d %d \n",count, i);
            count++;
        }
        return dp[amount];
    }

    public static void main(String[] a) {
        System.out.println(new CoinChange().coinChange(new int[]{5,3,1}, 11));
    }
}
