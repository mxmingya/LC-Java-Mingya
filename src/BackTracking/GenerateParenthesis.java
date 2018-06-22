package BackTracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingyama on 9/21/17.
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new LinkedList<>();
        List<String> result = new LinkedList<>();
        helper(n, result, new StringBuilder(), 0,0);
        return result;
    }

    private void helper(int n, List<String> result, StringBuilder current, int left, int right) {
        if (left == n && right == n) {
            result.add(current.toString());
            return;
        }
        System.out.printf("left=%d, right=%d ",left,right);
        System.out.printf("current length=%d\n", current.length());
        if (left < n) {
            current.append("(");
            helper(n, result, current, left+1, right);
            current.deleteCharAt(current.length()-1);
        }
        if (left > right) {
            current.append(")");
            helper(n, result, current, left, right +1);
            current.deleteCharAt(current.length()-1);
        }

    }

    public static void main(String[] args) {
        int n = 3;
        for (String s : new GenerateParenthesis().generateParenthesis(n)) {
            System.out.print(s + " ");
        }
        System.out.println(Double.parseDouble("30"));
    }
}
