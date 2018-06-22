package FB;
import java.util.*;
/**
 * Created by mingyama on 10/21/17.
 */
public class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        // ()()))()
        // ( ()))() last delete:1, lastinvalid:4
        // ( ( ))() last delete:3, lastInvalid:5
        // ()(( ) )
        List<String> res = new LinkedList<>();
        if (s == null || s.length() == 0) return res;
        helper(s, res, 0, 0, new char[] {'(', ')'});
        return res;
    }

    private void helper(String s, List<String> res, int lastInvalid, int lastDelete, char[] paren) {
        System.out.println("called");
        for (int left=0, i = lastInvalid; i < s.length(); i++) {
            System.out.printf("%d, %d\n", i, left);
            char cur = s.charAt(i);
            if (cur == paren[0]) left++;
            if (cur == paren[1]) left--;
            if (left >= 0) continue;
            for (int j = lastDelete; j <= i; j++) { // i: index of invalid foundded, j, from last deleted parenthesis
                System.out.printf("inside: %d, %d", j, i);
                if (s.charAt(j) == paren[1] && (j == lastDelete || s.charAt(j-1) != paren[1])) {
                    helper(s.substring(0, j) + s.substring(j+1, s.length()), res, i, j, paren);
                }
            }
            return;
        }
        System.out.println("been here");
        String reverse = new StringBuilder(s).reverse().toString();

        if (paren[0] == '(') {
            System.out.printf("called2, s: %s\n", s);
            helper(reverse, res, 0, 0, new char[]{')', '('});
        } else {
            System.out.println("been here");
            res.add(reverse);
        }
    }

    public static void main(String[] a) {
        for (String s : new RemoveInvalidParenthesis().removeInvalidParentheses("()()))()")) {
            System.out.printf("%s ", s);
        }
    }
}
