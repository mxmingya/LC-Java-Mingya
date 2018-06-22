package BackTracking;
import java.util.*;
/**
 * Created by mingyama on 9/28/17.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res= new LinkedList<>();
        dfs(s, 0, res, new LinkedList<>());
        return res;
    }

    private void dfs(String s, int start, List<List<String>> res, List<String> current) {
        if (start == s.length()) {
            System.out.printf("been here start:%d \n", start);
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = start+1; i <= s.length(); i++) {
//            System.out.printf("start: %d i: %d \n", start, i);
            if (valid(s.substring(start, i))) {
//                System.out.println(s.substring(start, i));
                current.add(s.substring(start, i));
                dfs(s, i, res, current);
                current.remove(current.size()-1);
            }
        }
    }

    private boolean valid(String s) {
        int left =0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt((right--))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (List<String> s_list : new PalindromePartitioning().partition("aab")) {
            for (String s : s_list) System.out.printf("%s ", s);
            System.out.println("");
        }
    }

}
