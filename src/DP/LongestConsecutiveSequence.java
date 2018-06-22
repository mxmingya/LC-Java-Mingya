package DP;

import java.util.HashMap;

/**
 * Created by mingyama on 9/7/17.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }

            int left = map.containsKey(num-1) ? map.get(num-1) : 0;
            int right = map.containsKey(num+1) ? map.get(num+1) : 0;

            int currentLength = left + right + 1;
            map.put(num, currentLength);
            maxLength = Math.max(currentLength, maxLength);
            System.out.println(currentLength);
            // update left right boundaries
            if (left != 0) map.put(num-1, currentLength);
            if (right != 0) map.put(num+1, currentLength);
        }

        return maxLength;
    }

    public static void main(String[] a) {
        LongestConsecutiveSequence test = new LongestConsecutiveSequence();
        System.out.println(test.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
