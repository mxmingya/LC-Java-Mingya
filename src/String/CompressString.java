package String;

/**
 * Created by mingyama on 10/17/17.
 */
public class CompressString {
    public String compressString(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int count = 1;

            while (i + 1 < len && s.charAt(i) == s.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(s.charAt(i)).append(count);
        }
//        double x = (double) 1 / (double) 2;
//        System.out.printf("%f", x);
        return sb.length() > len? s : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CompressString().compressString("aaabbc"));
        System.out.println(new CompressString().compressString("abcdef"));
    }
}
