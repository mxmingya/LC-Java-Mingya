package FB;

/**
 * Created by mingyama on 10/21/17.
 */
public class isPalintrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int left=0, right=s.length()-1;

        while (left < right) {
            while (!Character.isLetter(s.charAt(left))) left++;
            while (!Character.isLetter(s.charAt(right))) right--;
            String c1 = (s.charAt(left) + "").toLowerCase();
            String c2 = (s.charAt(right) + "").toLowerCase();

            if (!c1.equals(c2) ) {
                System.out.printf("%s, %s\n", c1, c2);
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] a) {
        System.out.println(new isPalintrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
