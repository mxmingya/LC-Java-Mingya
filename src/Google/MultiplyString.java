package Google;

import java.util.*;

/**
 * Created by mingyama on 3/26/18.
 */
public class MultiplyString {

    public static String multiplyStrings(String s1, String s2) {
        // s1 = "12", s2 = "13", return "156
        // s1 = "189", s2 = "289"
        // 189
        // 289
        //-------
        //   1101
        if (s1 == null || s2 == null) return null;

        List<StringBuilder> sums = new LinkedList<>();
        int carrier = 0;
        for (int i = 0; i < s1.length(); i++) {

            StringBuilder curSum = new StringBuilder();
            for (int k = i; k > 0; k-- ) {
                curSum.append("0");
            }

            for (int j = s2.length()-1; j >= 0; j--) {
                int result = Integer.parseInt(String.valueOf(s1.charAt(i))) * Integer.parseInt(String.valueOf(s2.charAt(j)))+ carrier;

                carrier = result / 10;
                curSum.append(result % 10);
            }

            System.out.println();
            sums.add(curSum.reverse());
            System.out.print(curSum + " ");
        }



        int max = pitchZero(sums);
        StringBuilder ans = new StringBuilder();
        carrier = 0;

        for (int i = 0; i < max; i++) {
            // add these sums up
            int curSum = carrier;
            for (StringBuilder sb : sums) {
                curSum += Integer.parseInt(String.valueOf(sb.charAt(i)));
                carrier = curSum / 10;
                ans.append(curSum % 10);
            }
        }
        if (carrier != 0) {
            ans.append(carrier);
        }
        return ans.reverse().toString();

    }

    private static int pitchZero(List<StringBuilder> sums) {
        int max = 0;
        for (StringBuilder sum : sums) {
            if (sum.length() > max) {
                max = sum.length();
            }
        }
        for (StringBuilder sum : sums) {
            while (sum.length() < max) {
                sum.append("0");
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(multiplyStrings("12", "13"));
    }

}
