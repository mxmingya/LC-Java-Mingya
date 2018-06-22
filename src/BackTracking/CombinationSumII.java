package BackTracking;
import java.util.*;
/**
 * Created by mingyama on 9/25/17.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();

        Arrays.sort(candidates);
        HashMap<Integer, Integer> visited = new HashMap<>();
        int[] temp = candidates.clone();
        for (int i : candidates) {
            if (visited.containsKey(i)) {
                visited.put(i, visited.get(i) + 1);
            } else {
                visited.put(i, 1);
            }
        }
        backtrack(temp, target, res, new LinkedList<>(), visited, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, HashMap<Integer, Integer> visited, int start) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(list);
            Collections.sort(temp);
            if (!res.contains(temp)) res.add(temp);
            return;
        } else if (target < 0) return;

        for (int i = start; i < candidates.length; i++ ) {
            list.add(candidates[i]) ;
            backtrack(candidates, target-candidates[i], res, list, visited, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        for (List<Integer> list : new CombinationSumII().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8)) {
            for (int i : list) {
                System.out.printf("%d", i);
            }
            System.out.println("");
        }
    }
}
