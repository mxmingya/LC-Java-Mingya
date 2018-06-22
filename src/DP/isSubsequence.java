package DP;

/**
 * Created by mingyama on 9/16/17.
 */
public class isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int pointer = 0;
        if (t == null || s == null || s.length() > t.length()) return false;
        int result = 0;

        for (int i =0; i < t.length(); i++) {
            if (result == s.length()) return true;

            if (t.charAt(i) == s.charAt(pointer)) {
                pointer++;
                result++;
            }
        }
        System.out.printf("result: %d ", result);
        System.out.printf("pointer: %d ", pointer);
        return result == pointer && pointer == s.length();
    }

    public static void main(String[] a) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new isSubsequence().isSubsequence(s,t));
    }
}
