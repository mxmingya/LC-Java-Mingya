package BackTracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingyama on 9/22/17.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (n == 0 || n < k) return res;
        helper(n, k, new LinkedList<>(), res, 1);
        return res;
    }

    private void helper(int n, int k, List<Integer> list, List<List<Integer>> res, int start) {
        if (list.size() == k) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) { // use a start index to prevent duplicated computing.
//            if (list.contains(i) || (list.size() >= 1 && i < list.get(list.size()-1))) continue;
            list.add(i);
            helper(n, k, list, res, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(20,16));
    }


}
