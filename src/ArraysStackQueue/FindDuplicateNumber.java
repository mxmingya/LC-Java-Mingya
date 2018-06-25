package ArraysStackQueue;

public class FindDuplicateNumber {
    // lc 287: https://leetcode.com/problems/find-the-duplicate-number/description/
    // 利用binary search来搜索重复的数字，请注意搜索的array并不是nums中的index，
    // 而是 0 - n-1 这些数字的个数。
    // 比如： 1，3，4，2，2，
    // 第一个mid 为 0 + (4 - 0 ) / 2 = 2
    // 比2 小或者相等的数字有1，2，2 有3个
    // 所以重复的数字肯定在1，2之间
    // 因为我们搜索的范围为0-4，所以循环的判定结束条件为low =< high
    // 如果count <= mid，
    public int findDuplicate(int[] nums) {
        // 1,3,4,2,2,
        if (nums == null || nums.length == 0) return 0;
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i : nums) {
                if (i <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
