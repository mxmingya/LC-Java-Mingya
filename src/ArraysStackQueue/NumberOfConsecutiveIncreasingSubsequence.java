package ArraysStackQueue;

/**
 * Created by mingyama on 10/6/17.
 */
public class NumberOfConsecutiveIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int numOfLIS = 0;
        for (int i  =1 ; i <nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                while (i < nums.length && nums[i] > nums[i-1]) {
                    i++;
                }
                numOfLIS++;
            }
        }
        return numOfLIS;
    }

    public static void main(String[] a) {
        System.out.println(new NumberOfConsecutiveIncreasingSubsequence().findNumberOfLIS(new int[] {1,2,3,5,4,7}));
    }
}
