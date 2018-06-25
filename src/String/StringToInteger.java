package String;
import java.util.*;

public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        String s = str.trim();
        if (s.length() == 0) return 0;
        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1, s.length());
        } else if (s.charAt(0) == '+') {
            s = s.substring(1, s.length());
        }
        // System.out.println(s);
        List<Character> chars =  new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                chars.add(c);
            } else {
                break;
            }
        }
        long res = 0;
        for (char c : chars) {
            int cur = c - '0';
            res = res * 10 + cur;
            if (sign * res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return sign * (int) res;
    }
}
