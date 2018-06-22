package BackTracking;

/**
 * Created by mingyama on 9/15/17.
 */
public class AndroidUnlockPattern {
    public int numberOfPatterns(int m, int n) {
        // for every possible length, we start from 1, check if the current pattern valid,
        // if so, add 1 to the result answer,
        // to check if the current pattern valid, first check if it skips any num, if so,
        // check if the skipped num visited. if visited, it is still valid.
        // after checking all the possible patterns of the current length, process to the next possible pattern
        if (m == 0 || n == 0) return 0;
        int result = 0;
        boolean[] visited = new boolean[10];
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = 5;
        for (int i = m; i <= n; i++) {
            result += dfs(skip, visited, 1, i-1) * 4; // 1,3,7,9 are the same
            result += dfs(skip, visited, 2, i-1) * 4; // 2,4,6,8 are the same
            result += dfs(skip, visited, 5, i-1); // 5 is different
        }
        return result;
    }

    private int dfs(int[][] skip, boolean[] visited, int cur, int remain) {
        // @param remain for the number of steps remains for current length
        // @param cur, for current number that we are visiting. eg. 1
        if (remain < 0) return 0; // dont understand why this is neeed;
        if (remain == 0) return 1; // no step left and all patterns are valid so far
        visited[cur] = true;
        int result = 0; // count of valid pattern with current length

        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]]))
                result += dfs(skip, visited, i, remain-1);
        }

        visited[cur] = false;
        return result;
    }
}
