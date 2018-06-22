package DP;

/**
 * Created by mingyama on 9/16/17.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) return s.substring(i+1).equals(t.substring(i+1));
                else if (s.length() > t.length())
                    return s.substring(i+1).equals(t.substring(i));
                else
                    return s.substring(i).equals(t.substring(i+1));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    public static void main(String[] a) {
        System.out.println(new OneEditDistance().isOneEditDistance("abc", "abcd"));
        System.out.println(new OneEditDistance().isOneEditDistance("abc", "abcde"));
        System.out.println(new OneEditDistance().isOneEditDistance("", "a"));
        System.out.println(new OneEditDistance().isOneEditDistance("cb", "ab"));
        System.out.println(new OneEditDistance().isOneEditDistance("ab", "bc"));
        System.out.println(new OneEditDistance().isOneEditDistance("cb", "b"));
    }
}
