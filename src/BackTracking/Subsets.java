package BackTracking;

import java.util.*;

/**
 * Created by mingyama on 9/25/17.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp, int start) {
        res.add(new LinkedList<>(temp));
        for (int i =start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, res, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsets_iterative(int[] nums) {
        // do it iteratively
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<Integer>()); // add empty list
        for (int i =0; i < nums.length; i++) {
            int len = res.size();
            for (int j = 0; j < len; j++) {
                List<Integer> temp = new LinkedList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] agrs) {

        for (List<Integer> list : new Subsets().subsets_iterative(new int[] {1,2,3})) {
            for (int i : list) {
                System.out.printf("%d", i);
            }
            System.out.println("");
        }
        System.out.println("--------------");
        for (List<Integer> list : new Subsets().subsets(new int[] {1,2,3,4})) {
            for (int i : list) {
                System.out.printf("%d", i);
            }
            System.out.println("");
        }
    }
}
