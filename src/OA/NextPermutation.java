package OA;

/**
 * Created by mingyama on 2/22/18.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // which is equal to the question of finding the next larger number
        // find the first non-increasing permutation
        int i ;
        int len = nums.length;
        for ( i  = 0; i < len -1; i++) {
            if (nums[i] >= nums[i+1]) {
                break;
            }
        }
        // 1,2,3,4,5, i stops at 5, i = 5, return 5,4,3,2,1
        // 5,4,3,2,1, stops at 5
        // return 1,2,3,4,5
        if ( i == 0 ) {
            reverse(nums);
            return;
        } else if (i == len - 1) {
            int temp = nums[len-1];
            nums[len-1] = nums[len-2];
            nums[len-2] = temp;
            return;
        }

        int temp = Integer.MAX_VALUE; // next larger number
        int index;
        for (index = i + 1; index < len; index++) {
            if (nums[index] < temp && nums[index] > nums[i]) {
                temp = nums[index];
            }
        }

        nums[index] = nums[i];
        nums[i] = temp;
        sort(nums, i, nums.length-1);
    }

    private void reverse(int[] nums) {
        for (int i  = 0; i < (nums.length-1)/2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = temp;
        }
    }

    private void sort(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            int small = nums[i];
            for (int j = i + 1; j <= end; j++ ) {
                if (nums[i] < small) {
                    int temp = nums[i];
                    nums[i] = small;
                    small = temp;
                }
            }
            nums[i] = small;
        }
    }

    public static void main(String[] args) {
        int[] t1 = {1,2,3,4,5};
        new NextPermutation().nextPermutation(t1);
        for (int i : t1) {
            System.out.print(i + ", ");
        }
    }

}
