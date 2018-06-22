package BackTracking;
import java.util.*;
/**
 * Created by mingyama on 9/25/17.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=  new LinkedList<>();
        backtrack(k, n, res, new LinkedList<>(), 1);
        return res;
    }

    private void backtrack(int k, int n, List<List<Integer>> res, List<Integer> list, int start) {
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        } else if (list.size() == k ){
            return;
        }
        for (int i = start; i < 10; i++) {
            list.add(i);
            backtrack(k, n-i, res, list, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        for (List<Integer> list : new CombinationSumIII().combinationSum3(3, 7)) {
            for (int i : list) {
                System.out.printf("%d", i);
            }
            System.out.println("");
        }
    }
}
