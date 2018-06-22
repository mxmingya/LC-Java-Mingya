package DP;

/**
 * Created by mingyama on 9/7/17.
 */
public class BestTimeBuyandSellStockIV {
    public int maxProfit(int[] prices) {
        int previous_sell = 0, sell = 0, buy = Integer.MIN_VALUE, previous_buy = 0;
        System.out.print("previous buy: " );
        System.out.println(previous_buy);
        System.out.print("buy: " );
        System.out.println(buy);
        System.out.print("previous sell: " );
        System.out.println(previous_sell);
        System.out.print("sell: " );
        System.out.println(sell);
        for (int i = 0; i < prices.length; i++) {
            previous_buy = buy;
            buy = Math.max(previous_sell - prices[i], buy); // compare profit of buy this time, and buy last time. if buying last time(buy) is less buying this time(previous_sell-price), we buy.
            previous_sell = sell;
            sell = Math.max(previous_buy + prices[i], sell); //compare profit of sell this time, and sell last time.
//            System.out.print("previous buy: " );
//            System.out.println(previous_buy);
            System.out.print("buy: " );
            System.out.println(buy);
//            System.out.print("previous sell: " );
//            System.out.println(previous_sell);
            System.out.print("sell: " );
            System.out.println(sell);
        }

        return sell;
    }
    public int maxProfit_(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k+1][n];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else {
                    int max = Integer.MIN_VALUE;
                    for (int m = 0; m < j; m++) {
                        max = Math.max(prices[j] - prices[m] + dp[i-1][m], max);
                    }
                    dp[i][j] = Math.max(max, dp[i-1][j]);
                }
            }
        }
        return dp[k][n-1];
    }

    public static void main(String[] args) {
        BestTimeBuyandSellStockIV test = new BestTimeBuyandSellStockIV();
        System.out.println(test.maxProfit_(3, new int[]{1,2,3,2,4}));
    }
}
