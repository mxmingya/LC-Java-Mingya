package OA;

/**
 * Created by mingyama on 2/27/18.
 */
public class GoogleOApractice {
    public String solution(String S, int K) {
        // write your code in Java SE 8
        if (S == null || S.length() == 0 || S.length() < K) return S;
        String s = regroup(S);
        System.out.println("s is " + s);
        StringBuilder sb = new StringBuilder();
        int firstGroup = s.length()% K;
        System.out.println("offset is: " + firstGroup);
        sb.append(s.substring(0,firstGroup));
        sb.append("-");
        for (int i = firstGroup; i < s.length(); i=i+K) {
            if (i + K > s.length()) break;
            sb.append(s.substring(i, i+K));
            sb.append("-");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    private String regroup(String S) {
        // cancel all the dishes and concat the string
        String[] strs = S.split("-");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.toUpperCase());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new GoogleOApractice().solution("2-4A0r7-4k", 4));
    }
}
