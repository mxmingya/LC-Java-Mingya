package ArraysStackQueue;
import java.util.*;
/**
 * Created by mingyama on 10/4/17.
 */
public class KDiffParisInAnArray {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return 0;
        Map<Integer, Integer> visited = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs(nums[i]-nums[j]) == k) {
                    if (visited.containsKey(nums[i]) && visited.get(nums[i]) == nums[j]) {
                        System.out.printf("been here %d %d\n", nums[i], nums[j]);
                        continue;
                    }
                    if (visited.containsKey(nums[j]) && visited.get(nums[j]) == nums[i]) {
                        System.out.printf("been here too %d %d\n", nums[i], nums[j]);
                        continue;
                    }
                    // else if (visited.containsKey(nums[i])) visited.put(nums[i], nums[j]);
                    System.out.printf("%d %d\n", nums[i], nums[j]);
                    visited.put(nums[i], nums[j]);
                    count++;
                }
            }
        }
        for(int i : visited.keySet()) {
            System.out.printf("%d %d|| ", i, visited.get(i));
        }
        System.out.println();
        return count;
    }

    public static void main(String[] a) {
        System.out.println(new KDiffParisInAnArray().findPairs(new int[] {6,2,9,3,9,6,7,7,6,4}, 3));
    }
}
