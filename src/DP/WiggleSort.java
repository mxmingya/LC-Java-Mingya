package DP;

/**
 * Created by mingyama on 9/15/17.
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i] < nums[i-1]) swap(nums, i);
            } else if (nums[i] > nums[i-1]) swap(nums, i);
        }
    }

    private void swap(int[] nums, int i) {
        // swap i and i-1
        int temp = nums[i];
        nums[i] = nums[i-1];
        nums[i-1] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 5, 2, 1, 6, 4};
        int[] test2 = new int[]{3, 5, 2};
        int[] test3 = new int[]{3, 5};
        int[] test4 = new int[]{3, 5,2,2};
        int[] test5 = new int[]{3, 5,2,2,2};
        new WiggleSort().wiggleSort(test);
        new WiggleSort().wiggleSort(test2);
        new WiggleSort().wiggleSort(test3);
        new WiggleSort().wiggleSort(test4);
        new WiggleSort().wiggleSort(test5);
        for (int i : test) {
            System.out.printf("%s ", i);
        }
    }
}
