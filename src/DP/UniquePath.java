package DP;

/**
 * Created by mingyama on 10/6/17.
 */
public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] steps = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) steps[i][j] = 1;
                else {
                    steps[i][j] = steps[i-1][j] + steps[i][j-1];
                }
            }
        }
        return steps[m-1][n-1];
    }

    public int uniquePaths_1d(int m, int n) {
        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                steps[j] = steps[j] + steps[j-1];
            }
        }
        return steps[n-1];
    }
}
