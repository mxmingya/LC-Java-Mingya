package DP;

/**
 * Created by mingyama on 9/17/17.
 */
public class BestTimeToBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        // sell and buy cannot happen at the same time, meaning that sell stock and buy stock cannot happen on the same day!
        // so for the same day, there could be three options, buy, sell, or not buy/sell.
        // however it has to follow this order: sell, rest, buy
        // since it has at most two transactions to complete.
        // we can have dp[i][j], dp[i][j] for profit of buying stocking today when j times transactions, dp[i][1] for best profit of selling stock today
        // state transfer function: dp[i][0] =
        return 90;
    }
}
