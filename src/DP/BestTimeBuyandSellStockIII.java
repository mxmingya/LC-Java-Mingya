package DP;

import java.util.Arrays;

/**
 * Created by mingyama on 9/21/17.
 */
public class BestTimeBuyandSellStockIII {
    public int maxProfit_naive(int[] prices) {
        // naive way
        if (prices == null) return 0;
        int maxProfit = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) { // first buy
            for (int j = i; j < len; j++) { // first sell
                for (int k = j; k < len; k++) { //second buy
                    for (int h = k; h < len; h++) { // second sell
//                        System.out.printf("i= %d, j=%d, k=%d, h=%d\n", i,j,k,h);
                       maxProfit = Math.max(prices[h] - prices[k] + prices[j] - prices[i], maxProfit);
                    }
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int[][] profits = new int[prices.length+1][prices.length];
        Arrays.fill(profits[0], 0);
        for (int i = 0; i < profits.length; i++) {
            profits[i][0] = 0;
        } //initiate first row and first column as all 0s since the max profit of first day is 0;
        for (int i = 1; i < 3; i++) { // ith transition
            for (int j = 1; j < prices.length; j++) { // current stock price
                int cur_profit = 0;
                for (int m = 0; m < j; m++) { //m is the last day of selling the stock
                    // if do not do any trasition today, maxprofit = profits[i][j-1]
                    // prices[m] buy stock at daym, prices[j] profits get from selling the stock today, profits[i-1][j] best profits we can get from i-1 transition
                    cur_profit = Math.max(cur_profit, prices[m] + profits[i-1][m]);
                }
                profits[i][j] = Math.max(cur_profit + prices[j], profits[i-1][j]);
            }
        }
        for (int i = 0;i < profits.length; i++) {
            for (int j = 0; j < profits[0].length; j++) {
                System.out.print(profits[i][j]);
            }
            System.out.println();
        }
        return profits[2][prices.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeBuyandSellStockIII().maxProfit(new int[] {2,5,7,1,4,3,1,3}));
        System.out.println(new BestTimeBuyandSellStockIII().maxProfit_naive(new int[] {2,5,7,1,4,3,1,3}));
    }
}
