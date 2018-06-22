package ArraysStackQueue;

/**
 * Created by mingyama on 10/21/17.
 */
public class SubarrayProductLessK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int len = 1; len <= nums.length; len++) {
            for (int begin = 0; begin + len <= nums.length; begin++) {
                int product = 1;
                for (int i = begin; i < begin + len; i++) {
                    product *= nums[i];

                }
                if (product < k) {
                    System.out.printf("%d, %d, %d\n", len, begin, product);
                    res++;
                }
            }
        }
        return res;
    }
    public static void main(String[] a) {
        System.out.println(new SubarrayProductLessK().numSubarrayProductLessThanK(new int[] {10,9,10,4,3,8,3,3,6,2,10,10,9,3},
        19));
    }
}
