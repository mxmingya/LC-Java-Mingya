package DP;

/**
 * Created by mingyama on 9/5/17.
 */
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    path[i][j] = -1;
                }
            }
        }
        // initialize first row and first column
        for (int i = 0; i < m; i++) {
            if (path[i][0] == -1) break;
            path[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (path[0][j] == -1) break;
            path[0][j] = 1;
        }
        // when encounter a obstacle,
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (path[i][j] == -1) continue;
                    if (path[i-1][j] == -1) path[i][j] = path[i][j-1];
                else if (path[i][j-1] == -1) path[i][j] = path[i-1][j];
                else {
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }
            }
        }
        for (int[] i : path) {
            for (int in : i) {
                System.out.print(in);
            }
            System.out.println("");
        }
        return path[m-1][n-1];
    }

    public int refinedUniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] paths = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            paths[i] = obstacleGrid[0][i] == 1 ? 0 : 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        paths[j] = 0;
                    } else {
                        paths[j] = 1;
                    }
                }
                paths[j] += paths[j-1];
            }
        }
        return paths[paths.length-1];
    }

    public static void main(String[] args) {
        UniquePathII test = new UniquePathII();
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        int res = test.uniquePathsWithObstacles(arr);
        System.out.println(res);
        System.out.println(-1+1);
        System.out.println(-(-1+1));

    }
}
