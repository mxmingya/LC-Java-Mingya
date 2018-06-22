package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingyama on 9/22/17.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        helper(nums, new LinkedList<>(), result);
        return result;
    }

    private void helper(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (nums.length == current.size()) {
            System.out.println("been here");
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i])) continue;
            System.out.println(nums[i]);

            current.add(nums[i]);
            helper(nums, current, result);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] agrs) {
        for (List<Integer> l : new Permutations().permute(new int[] {1,2,3})) {
            System.out.println(l);
        };
    }
}
