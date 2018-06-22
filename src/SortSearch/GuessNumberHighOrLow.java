package SortSearch;

/**
 * Created by mingyama on 9/10/17.
 */
public class GuessNumberHighOrLow {
    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int jminusi = 1; jminusi < n; jminusi++) {
            System.out.print("j - i: ");
            System.out.println(jminusi);
            for (int i = 0; i + jminusi <= n; i++) {
                int j = i + jminusi;
                dp[i][j] = Integer.MAX_VALUE;
                System.out.print("k is: ");
                for (int k = i; k <= j; k++) {

                    System.out.print(k);
                    System.out.print(",");
                    dp[i][j] = Math.min(dp[i][j],
                            k + Math.max(k - 1 >= i ? dp[i][k - 1] : 0,
                                    j >= k + 1 ? dp[k + 1][j] : 0));
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String args) {
        GuessNumberHighOrLow test = new GuessNumberHighOrLow();
        System.out.println(test.getMoneyAmount(10));
    }
}
