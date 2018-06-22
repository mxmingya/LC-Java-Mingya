package SortSearch;

import java.util.Hashtable;

/**
 * Created by mingyama on 10/16/17.
 */
public class SortColor {
    public void sortColors(int[] nums) {
        int numBlue =0, numRed = 0;
        for (int i : nums) {
            if (i == 0) {
                numRed++;
            }
            if (i == 2) {
                numBlue++;
            }
        }

        for (int i =0; i < numRed; i++) {
            nums[i] = 0;
        }
        for (int i = nums.length-1; i>=0; i--) {
            nums[i] = 2;
        }

        for (int i = numRed; i < nums.length-numBlue; i++) {
            nums[i] = 1;
        }

//        Hashtable<?,?> t = new Hashtable<>();
    }

    public void sortColorsOnePass(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        int j = 0, k = len -1;// j is the index of 0, k index of 2
        for (int i = 0; i <= k; i++) {
            if (nums[i] == 0) {
                swap(i, j, nums);
                j++;
            } else if (nums[i] == 2) {
                swap(i, k, nums);

                i--;
                k--;
            }
        } // 2,0,2,1,1,1,0
        // 0,0,2,1,1,1,2
        // 0,0,1,1,1,2,2
        // j: 0,1,
        // k: 5, 4
    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
