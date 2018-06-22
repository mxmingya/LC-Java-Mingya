package String;

public class PalindromeInteger {
    // 利用string可以化成array的特性，来转化成比较简单的题
    public boolean isPalindrome(int x) {
        String  s = Integer.toString(x);
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
