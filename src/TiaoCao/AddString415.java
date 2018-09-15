package TiaoCao;

public class AddString415 {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        while (i >=0 || j >= 0 || carry == 1) {
            int cur = 0;
            if (i >= 0) {
                cur += num1.charAt(i) - '0';
            }
            if (j >= 0) {
                cur += num2.charAt(j) - '0';
            }
            cur += carry;
            int res = cur % 10;
            carry = cur / 10;
            sb.append(res);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
