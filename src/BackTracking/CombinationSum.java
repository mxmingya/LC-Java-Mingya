package BackTracking;
import java.util.*;
/**
 * Created by mingyama on 9/25/17.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // find all unique combination contains numbers from candidates that sum up to ytarget
        List<List<Integer>> res=  new LinkedList<>();
        backtrack(candidates, target, res, new LinkedList<>(), 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int start) {
        int currentSum = 0;
        for (int i : list) {
            if (currentSum > target) return;
            currentSum += i;
        }
        if (currentSum == target && !res.contains(list)) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, target, res, list, i);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] agrs) {

        for (List<Integer> list : new CombinationSum().combinationSum(new int[]{ 2,3,6,7}, 7)) {
            for (int i : list) {
                System.out.printf("%d", i);
            }
            System.out.println("");
        }
    }

}
