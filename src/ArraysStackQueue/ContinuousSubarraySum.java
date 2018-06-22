package ArraysStackQueue;

/**
 * Created by mingyama on 10/10/17.
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return false;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) return true;
                else if (k != 0 && sum % k == 0) return true;
            }
        }
        return false;
    }

    public static void main(String[] a) {
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{1,2,3}, 5));
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{1,2,3}, 4));
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{0,1,0}, 0));
    }
}
