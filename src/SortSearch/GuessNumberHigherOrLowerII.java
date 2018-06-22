package SortSearch;

/**
 * Created by mingyama on 9/10/17.
 */
public class GuessNumberHigherOrLowerII {
    public static int getMoneyAmount(int n) {
        int[][] pay = new int[n+1][n+1];// represent the cost of 0~n costs
        for (int i= 2; i <= n; i++) {
            for (int j=i-1; j>0; j--) {
                int globalMin = Integer.MAX_VALUE;
                for (int k=j+1; k<i; k++) {
                    // pay[j][i] represents the payment j~~i.
                    // eg 1-5, we check min(1~2+3+4~5, 1~3+4+5~5), 3 and 4 here is the k
                    // get local max due to we need to always count on the worst scenerios, get globalMin because we want spend the least money to won the game
                    int localMax = Math.max(pay[j][k-1], pay[k+1][i]) + k;
                    globalMin = Math.min(globalMin, localMax);
                }
                pay[j][i] = i==j+1 ? i : globalMin; // for 4~5, we pay 5, cuz this is the worst scenerio
                System.out.printf("pay[%d][%d] is : %d", j, i, pay[j][i]);
            }
        }

        return pay[1][n]; // cost to guess 1~n
    }

    public static void main(String[] args) {
        System.out.println(getMoneyAmount(2));
    }
}
