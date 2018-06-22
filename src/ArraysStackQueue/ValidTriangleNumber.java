package ArraysStackQueue;
import java.util.*;

public class ValidTriangleNumber {
    // 此类型是要找一些数字，这些数字组合起来要满足一些条件， 一般有两种做法：
    // 1。 用hashmap来优化查询复杂度
    // 2。 或者用sort之后来两边同时缩短来算法总体降低复杂度
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0, len = nums.length;
        for (int i = len-1; i >= 2; i--) {
            int left = 0, right = i-1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        // 2,2,3,4
        return res;
    }
}
