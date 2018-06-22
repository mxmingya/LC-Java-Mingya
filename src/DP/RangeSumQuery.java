package DP;

/**
 * Created by mingyama on 9/16/17.
 */
public class RangeSumQuery {
    class NumArray {
        int[] dp;
        public NumArray(int[] nums) {
            dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = nums[i] + dp[i-1];
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) return dp[j];
            return dp[j] - dp[i-1];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
