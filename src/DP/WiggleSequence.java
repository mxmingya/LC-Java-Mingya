package DP;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingyama on 9/15/17.
 */
public class WiggleSequence {
    public int wiggleMaxLength_slow(int[] nums) {
        //this works but not optimal
        if (nums.length <= 1) return nums.length;
        if (nums.length == 2) return nums[0] == nums[1] ? 1 : 2;
        // compute the difference of the array elements
        List<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        list.add(nums[1]);

        for (int i =2; i < nums.length; i++) {
            // trying to find a smaller number
            if (list.get(list.size()-1) > list.get(list.size()-2)) {
                if (nums[i] > list.get(list.size()-1)) list.set(list.size()-1, nums[i]); // replace it with the current number since the current one is larger
                else if (nums[i] < list.get(list.size()-1)) list.add(nums[i]);
            } //trying to find a larger number
            else {
                // if larger than the last one
                if (nums[i] > list.get(list.size()-1)) list.add(nums[i]);
                else if (nums[i] < list.get(list.size()-1)) list.set(list.size()-1, nums[i]);
            }
        }

        return list.get(0) == list.get(1) ? list.size() - 1 : list.size();
    }

    public int wiggleMaxLength_doesnt_work(int[] nums) {
        // use two pointers, like LIS, does not work
        if (nums.length <= 1) return nums.length;

        int start = 0, end = 2, res = 2;
        for (int i =2; i <nums.length; i++) {
            // if wiggle
            if (nums[end] > nums[end-1] && nums[end-1] < nums[end-2]) {
                end++;
                res = Math.max(end-start, res);
            } else if (nums[end] < nums[end-1] && nums[end-1] > nums[end-2]) {
                end++;
                res = Math.max(end-start, res);
            } else {
                //not wiggle
                start = i-1;
                end = i+1;
            }
        }

        return nums[0] == nums[1] ? res-1 : res;
    }

    public int wiggleMaxLength(int[] nums) {
        // from the discussion, use two arrays to record the wiggle up times and wiggle down times till last number
        // it works because eg. [1,2,3], if up[i] = down[i-1], up[1] = down[0]+1 = 2, up[2] = down[1]+1 = 2;
        // https://discuss.leetcode.com/topic/52076/easy-understanding-dp-solution-with-o-n-java-version
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        if (nums.length <= 1) return nums.length;

        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { // wiggle up
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {// wiggle down
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(up[up.length-1], down[down.length-1]);
    }


        public static void main(String[] a) {
        System.out.println(new WiggleSequence().wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(new WiggleSequence().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(new WiggleSequence().wiggleMaxLength(new int[]{1}));
        System.out.println(new WiggleSequence().wiggleMaxLength(new int[]{}));
        System.out.println(new WiggleSequence().wiggleMaxLength(new int[]{1,2}));
        System.out.println(new WiggleSequence().wiggleMaxLength(new int[]{1,1}));
        System.out.println(new WiggleSequence().wiggleMaxLength(new int[]{1,1,1}));
    }
}
