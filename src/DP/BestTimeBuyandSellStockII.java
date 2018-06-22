package DP;

/**
 * Created by mingyama on 9/21/17.
 */
public class BestTimeBuyandSellStockII {
    public int maxProfit(int[] prices) {
        // this is to find the longest sequence
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeBuyandSellStockII().maxProfit(new int[]{1,5,2,7}));
        System.out.println(new BestTimeBuyandSellStockII().maxProfit(new int[]{1,2,3,4,5}));
    }
}
