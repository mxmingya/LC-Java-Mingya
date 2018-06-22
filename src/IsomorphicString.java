import javax.print.attribute.standard.MediaSize;

/**
 * Created by mingyama on 10/11/17.
 */
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        int[] a1 = new int[256];
        int[] a2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (a1[s.charAt(i)-'0'] != a2[t.charAt(i)-'0']) return false;
            a1[s.charAt(i)-'0'] = i + 1;
            a2[t.charAt(i)-'0'] = i + 1;
        }
        return true;
    }

    public static void main(String[] a) {
        System.out.println(new IsomorphicString().isIsomorphic("ab", "aa"));
        System.out.println(new IsomorphicString().isIsomorphic("add", "egg"));

    }
}
