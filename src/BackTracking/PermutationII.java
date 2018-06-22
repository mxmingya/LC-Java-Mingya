package BackTracking;

import java.util.*;

/**
 * Created by mingyama on 9/22/17.
 */
public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // similar to permutation I but with duplicates
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<List<Integer>> set = new HashSet<>();
        helper(nums, 0, set, map);
        return new LinkedList<>(set);
    }

    private void helper(int[] nums, int pos, HashSet<List<Integer>> set, HashMap<Integer, Integer> map) {
        if (pos == nums.length) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i : nums) temp.add(i);
            if (set.contains(temp)) return;
            set.add(temp);
        } else {
            // nums[1,1,2] => nums[2,1,1]
            for (int j = pos; j < nums.length; j++) {
                if (map.containsKey(nums[j]) && map.get(nums[j]) == nums[pos]) continue;
                swap(nums, pos, j);
                helper(nums, pos+1, set, map);
                swap(nums, pos, j);
            }
        }
    }

    private void swap(int[] nums, int pos1, int pos2) {
        if (pos1 == pos2) return;
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationII().permuteUnique(new int[] {1,1,2}));
        System.out.println(Math.pow(1,2));
    }
}
