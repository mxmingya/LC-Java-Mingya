package DP;

import java.util.Arrays;

/**
 * Created by mingyama on 9/16/17.
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) return;
        int[] cloned = nums.clone();
        int len = nums.length-1;
        Arrays.sort(cloned);
        int mid = (nums.length+1) /2;
        for (int i=0; i <nums.length; i++) {
            nums[i] = i % 2 == 0 ? cloned[mid--] : cloned[len--];
        }
    }


    public static void main(String[] a) {
        int[] t = {3,5,1,6,2,4};
        int[] t2 = {3,5,2,2,2};
        new WiggleSortII().wiggleSort(t2);
        new WiggleSortII().wiggleSort(t);
        for (int i : t2) System.out.printf("%d",i);
    }
}
