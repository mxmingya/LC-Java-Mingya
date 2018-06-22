package ArraysStackQueue;
import java.util.*;
/**
 * Created by mingyama on 10/6/17.
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        Map<Integer, Integer> numToCounts = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            numToCounts.put(nums1[i], numToCounts.getOrDefault(nums1[i], 1)+1);
        }

        for (int i = 0; i < nums2.length; i++) {
            int cur = nums2[i];
            if (numToCounts.containsKey(cur) && numToCounts.get(cur) > 0) {
                res.add(cur);
                numToCounts.put(cur, numToCounts.get(cur)-1);
            }
        }

        int[] results = new int[res.size()];
        int index = 0;
        for (int i : res) {
            results[index++] = i;
        }
        return results;
    }
    public static void main(String[] a) {
        for (int i : new IntersectionOfTwoArraysII().intersect(new int[]{1,2,2,4}, new int[] {2,2})) {
            System.out.printf("%d,", i);
        }
    }
}
