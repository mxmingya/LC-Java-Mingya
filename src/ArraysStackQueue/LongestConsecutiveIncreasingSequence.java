package ArraysStackQueue;

/**
 * Created by mingyama on 10/6/17.
 */
public class LongestConsecutiveIncreasingSequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxLength = 1;
        for (int i  =1 ; i <nums.length; i++) {
            int temp = 1;
            if (nums[i] > nums[i-1]) {
                while (i < nums.length && nums[i] > nums[i-1]) {
                    temp++;
                    i++;
                }
                maxLength = temp > maxLength ? temp : maxLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] a) {
        System.out.println(new LongestConsecutiveIncreasingSequence().findLengthOfLCIS(new int[] { 1,3,5,4,7}));
        System.out.println(new LongestConsecutiveIncreasingSequence().findLengthOfLCIS(new int[] { 2,2,2,2,2}));
    }
}
