package BackTracking;
import java.util.*;
/**
 * Created by mingyama on 10/7/17.
 */
public class targetSum {
    public int findTargetSumWays_slow(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        List<List<Integer>> res = new LinkedList<>();
        backtrack(nums, S, res, new LinkedList<>(), 0, 0);
        return res.size();
    }

    private void backtrack(int[] nums, int S, List<List<Integer>> res, List<Integer> cur, int curSum, int start) {
        if (cur.size() == nums.length && curSum == S) {
            res.add(new LinkedList<>(cur));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(nums, S, res, cur, curSum+nums[i], i+1);
            cur.remove(cur.size()-1);
            cur.add(0-nums[i]);
            backtrack(nums, S, res, cur, curSum-nums[i], i+1);
            cur.remove(cur.size()-1);
        }
    }


    public int findTargetSumWays_2(int[] nums, int S) {
        int[] count = new int[1];
        dfs(nums, S, count, 0);
        return count[0];
    }

    private void dfs(int[] nums, int S, int[] count, int start) {
        if (start == nums.length) {
            if (S == 0) {
                count[0] = count[0]+1;
            }
            return;
        }
        dfs(nums, S+nums[start], count, start+1);
        dfs(nums, S-nums[start], count, start+1);
    }

    public static void main(String[] a ) {
        System.out.println(new targetSum().findTargetSumWays_2(new int[] {1,1,1,1,1}, 3));
    }

}
