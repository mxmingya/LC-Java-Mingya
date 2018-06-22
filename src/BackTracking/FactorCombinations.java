package BackTracking;
import java.util.*;
/**
 * Created by mingyama on 9/25/17.
 */
public class FactorCombinations {
    public List<List<Integer>> getFactor(int n) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack( n, 2, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int n, int start, List<List<Integer>> res, List<Integer> current) {
        if (n <= 1) {
            if (current.size() >= 2) {
                res.add(new ArrayList<>(current));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                System.out.printf("been here %d ", i);
                current.add(i);
                backtrack(n / i, i, res, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        for (List<Integer> list : new FactorCombinations().getFactor(12)) {
            for (int i : list) {
                System.out.printf("%d ", i);
            }
            System.out.println("");
        }    }
}
