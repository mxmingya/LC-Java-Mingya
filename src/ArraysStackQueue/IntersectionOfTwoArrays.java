package ArraysStackQueue;
import java.util.*;
/**
 * Created by mingyama on 10/6/17.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        Map<Integer, Integer> numToCounts = new HashMap<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            numToCounts.put(nums1[i], numToCounts.getOrDefault(nums1[i], 1)+1);
        }
        for(int i : numToCounts.keySet()) System.out.printf("%d ", i);
        System.out.println("");
        for (int i = 0; i < nums2.length; i++) {
            int cur = nums2[i];
            if (numToCounts.containsKey(cur) && numToCounts.get(cur) > 0) {
                res.add(cur);
                numToCounts.put(cur, numToCounts.get(cur)-1);
            }
        }
        for (int i : res) System.out.printf("%d ", i);
        System.out.println("");
        int[] results = new int[res.size()];
        int index = 0;
        for (int i : res) {
            System.out.printf("index:%d i:%d", index, i);
            results[index++] = i;
        }
        return results;
    }

    public static void main(String[] a) {
        for (int i : new IntersectionOfTwoArrays().intersection(new int[]{1,2}, new int[] {2,1})) {
            System.out.printf("%d ", i);
        }
    }
}
