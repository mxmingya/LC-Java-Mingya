package BackTracking;
import java.util.*;
/**
 * Created by mingyama on 10/10/17.
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        Set<List<Integer>> res = new HashSet<>();
        dfs(nums, target, res, new LinkedList<>());
        return res.size();
    }

    private void dfs(int[] nums, int target, Set<List<Integer>> res, List<Integer> list) {
        if (target <= 0) {
            if (target == 0 && !res.contains(list)) {
                res.add(list);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            target -= nums[i];
            list.add(nums[i]);
            dfs(nums, target, res, list);
            list.remove(list.size()-1);
            target += nums[i];
        }
    }

    public static void main(String[] a) {
        System.out.println(new CombinationSumIV().combinationSum4(new int[] {1,2,3}, 4));
    }
}
