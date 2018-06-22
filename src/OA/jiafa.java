package OA;

/**
 * Created by mingyama on 3/27/18.
 */
public class jiafa {
    public void printSum(int n) {
        System.out.printf("Sum to Wat?\n%d\n", n);
        helper(n + 1, 1, new StringBuilder().append("1"), 0);
    }

    private void helper(int n, int cur, StringBuilder str, int sum) {
        if (cur == n) return;
        if (cur == 1) {
            str.append(" = 1");
            System.out.println(str);
        } else {
            if (str.indexOf("=") != -1) {
                str = new StringBuilder(str.substring(0, str.indexOf("=")-1));
            }
            str.append(" + ");
            str.append(cur);
            str.append(" = ");
            str.append(sum + cur);
            System.out.println(str);

        }
        helper(n, cur + 1, str, sum + cur);
    }

    public static void main(String[] args) {
        new jiafa().printSum(4);
        new jiafa().printSum(5);
        new jiafa().printSum(1);
//        new jiafa().printSum(Integer.MAX_VALUE);
    }
}
