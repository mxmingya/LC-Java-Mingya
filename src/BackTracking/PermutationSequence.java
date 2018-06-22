package BackTracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingyama on 9/22/17.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<String> res = new LinkedList<>();
        helper(n, res, new StringBuilder(),1);
        return res.get(k-1);
    }

    private void helper(int n, List<String> res, StringBuilder current, int start) {
        if (current.length() == n) {
            System.out.println("been here");
            res.add(new String(current));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (current.indexOf(Integer.toString(i)) != -1 ) continue;
            System.out.printf("%d ", i);
            current.append(Integer.toString(i)) ;
            helper(n, res, current, i+1);
            current.deleteCharAt(current.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3,2));
    }
}
