package FB;

/**
 * Created by mingyama on 10/22/17.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            String temp = a;
            a = b;
            b = temp;
        } // b is longer
        StringBuilder sum = new StringBuilder();
        int a_ = a.length()-1, carry = 0, b_ = b.length()-1;
        while ( a_ >= 0 && b_ >= 0 ) {
            int a1 = a.charAt(a_) - '0';
            int b1 = b.charAt(b_) - '0';
            int result = a1+b1+carry;
            System.out.printf("%d, %d, %d\n", a1, b1, result);
            if (result == 3) {
                sum.append(1);
            }
            if (result == 2) {
                sum.append(0);
                carry = 1;
            }
            else if (result == 1) {
                sum.append(1);
                carry = 0;
            }
            else if (result == 0) {
                sum.append(0);
            }
            System.out.println(sum);
            a_--;
            b_--;
        }
        while (b_ >= 0) {
            int b1 = b.charAt(b_) - '0';
            int result = b1+carry;
            if (result == 2) {
                sum.append(0);
                carry = 1;
            }
            else if (result == 1) {
                sum.append(1);
                carry = 0;
            }
            else if (result == 0) {
                sum.append(0);
            }
            b_--;
        }
        if (carry == 1) {
            sum.append(1);
        }
        return sum.reverse().toString();
    }

    public static void main(String[] a) {
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }
}
