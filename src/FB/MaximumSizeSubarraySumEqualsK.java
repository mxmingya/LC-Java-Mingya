package FB;

/**
 * Created by mingyama on 10/22/17.
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        int maxLength = 0;
        for (int i = dp.length-1; i >=0; i--) {
            for (int j = 0; j <= i; j++) {
                int sum = dp[i]-dp[j];
                if (sum == k) {
                    System.out.printf("i: %d, j: %d\n", i, j);
                    maxLength = Math.max(i-j, maxLength);
                }
            }
        }
        return maxLength;
    }
    public static void main(String[] a) {
        System.out.println(new MaximumSizeSubarraySumEqualsK().maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3));
    }
}
