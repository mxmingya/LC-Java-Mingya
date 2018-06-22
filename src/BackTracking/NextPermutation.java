package BackTracking;

/**
 * Created by mingyama on 9/22/17.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = nums.length-1;
        // find the index of first non decreasing number
        for (; index <= 0; index--) {
            if (nums[index] > nums[index--]) break;
        }
        System.out.println(index);
        if (index == -1 ) { // 6,5,4,3,2,1, reverse whole array
            reverseSort(nums, 0);
        } else {
            // otherwise reverse from the least larger number in array than nums[index]
            // find the num
            int minPos = index;
            while (minPos < nums.length-1) {
                if (nums[minPos] < nums[index] && nums[minPos] < nums[minPos+1]) minPos += 1;
            }

            swap(nums, minPos, index);
            reverseSort(nums, index+1);
        }
        for (int i : nums) {
            System.out.printf("%d ", i);
        }
    }

    private void reverseSort(int[] nums, int startPosi) {
        for (int i = startPosi+1; i<nums.length-1; i++){
            if (nums[i] < nums[i+1]) swap(nums, i, i+1);
        }
    }
    private void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3};
        new NextPermutation().nextPermutation(test);
        for (int i : test) System.out.printf("%d, ", i);
    }
}
