package FB;
import java.util.*;
/**
 * Created by mingyama on 10/29/17.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(num, target, 0,res,"",0,0);
        return res;
    }

    private void helper(String num, int target, int start, List<String> res, String current, long result, long mul) {
        System.out.println(current);
        if (start == num.length()) {
            if (target == result ) {
                res.add(current);
            }
            return;
        }
        for (int i = start; i < num.length(); i++) {
            // 0 is valid, 012 is not valid
            if ( i != start && num.charAt(start) == '0') break;
            long val = Long.parseLong(num.substring(start, i+1));
            if (start == 0) {
                helper(num, target, i+1, res, Long.toString(val), val, val);
            }
            else {
                helper(num, target, i+1, res, current+"+"+Long.toString(val), result+val, val);
                helper(num, target, i+1, res, current+"-"+Long.toString(val), result-val, -val);
                helper(num, target, i+1, res, current+"*"+Long.toString(val), result-mul+mul*val, mul*val);
            }
        }
    }

    public static void main(String[] a) {
        for (String s : new ExpressionAddOperators().addOperators("105", 5)) {
            System.out.printf("%s, ", s);
        }

    }
}
