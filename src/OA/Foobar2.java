package OA;

/**
 * Created by mingyama on 9/8/17.
 */
public class Foobar2 {
    public static int answer(String s) {
        if (s == null || s.length() == 0) return 0;
        int salute = 0;
        for (int i = 0; i < s.length(); i++) {
            char target;
            if (s.charAt(i) == '>') {
                System.out.println("> found!");
                target = '<';
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == target) {
                        salute++;
                    }
                }
            }
        }
        for (int i = s.length()-1; i >= 0; i--) {
            char target;
            if (s.charAt(i) == '<') {
                target = '>';
                for (int j =i-1; j >=0; j--) {
                    if (s.charAt(j) == target) {
                        salute++;
                    }
                }
            }
        }
        return salute;
    }

    public static void main(String[] a) {
        int ans = Foobar2.answer(">----<");
        int ans2 = Foobar2.answer("<<>><");
        System.out.println(ans);
        System.out.println(ans2);
    }
}
