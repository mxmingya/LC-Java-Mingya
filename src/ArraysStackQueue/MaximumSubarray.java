package ArraysStackQueue;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], cur = max > 0 ? max : 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0 && cur == 0) {
                max = max < num ? num : max;
                continue;
            }
            cur = cur + num > 0 ? cur + num : 0;
            max = cur > max ? cur : max;
        }
        return max;
    }
}
