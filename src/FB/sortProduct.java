package FB;
import java.util.*;
/**
 * Created by mingyama on 10/30/17.
 */
public class sortProduct {
    public List<String> sortProduct(List<String> versions) {
        // a4b3, a3b2, b1, ==> a3b2, a4b3, b1
        if (versions == null || versions .size() == 0) return versions;

        Collections.sort(versions, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return compareProducts(s1, s2);
            }
        } );

        return versions;
    }

    private int compareProducts(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int i = 0;
        for (; i < c1.length && i < c2.length; i++) {
            if (isDigit(c1[i]) && isDigit(c2[i])) {
                if (c1[i] < c2[i]) {
                    return -1;
                }
                else if (c1[i] > c2[i]) return 1;
            }
            else {
                if (c1[i] > c2[i]) return 1;
                else if (c1[i] < c2[i]) return -1;
            }
        }
        return c1.length - c2.length;
    }

    private boolean isDigit(char c) {
        return c <= '9' && c >= '0';
    }

    public static void main(String[] a) {
        List<String> versions = new LinkedList<String>();
        versions.add("a4b3");
        versions.add("a3b2");
        versions.add("b1");
        for (String v : new sortProduct().sortProduct(versions)) {
            System.out.printf("%s, ", v);
        }
    }
}
