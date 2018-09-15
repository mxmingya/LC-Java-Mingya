package TiaoCao;

public class licenseKeyFormating482 {
    public String licenseKeyFormatting(String S, int K) {
        if (K <= 0) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = S.length()-1; i>=0; i--) {

            if (S.charAt(i) != '-') {
                int len = sb.length();
                if (len %  (K+1) == K) {
                    sb.append("-"); // here is the key, find the place to insert -
                }
                sb.append(S.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
