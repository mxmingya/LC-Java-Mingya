package ArraysStackQueue;

public class RemoveDuplicateFromArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int index = i;
            while (index < nums.length && cur == nums[index]) {
                index++;
            }
            nums[last++] = cur;
            i = index-1;
            // System.out.printf("%d, %d, %d\n", cur, last, i);
        }
        return last;
    }
}
