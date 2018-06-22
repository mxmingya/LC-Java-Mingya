package BackTracking;

import java.util.*;
/**
 * Created by mingyama on 10/7/17.
 */
public class numberOfDistinctIslands {
    public int maxAreaIslands(int[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        Map<Integer, Integer> visited = new HashMap<>();
        int max = 0;
        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int[] area = new int[1];
                    dfs_(grid, i, j, area);
                    max = max > area[0] ? max : area[0];
                    count++;
                }
            }
        }
        return max;
    }

    private void dfs_(int[][] grid, int i, int j, int[] area) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;

        grid[i][j] = 0;
//        System.out.printf("been here");
        area[0]++;
        dfs_(grid, i+1, j, area);
        dfs_(grid, i-1, j, area);
        dfs_(grid, i, j+1, area);
        dfs_(grid, i, j-1, area);
    }

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Set<List<Integer>> edges = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> edge = new LinkedList<>();
                    dfs(grid, i, j, edge);
                    boolean flag = true;
                    for (List<Integer> pre : edges) {
                        if (pre.size() != edge.size()) continue;
                        if (!flag) break;
                        int diff1 = pre.get(0) - edge.get(0);
                        int diff2 = pre.get(1) - edge.get(1);
                        for (int k = 2; k < pre.size(); k=k+2 ) {
                            if (pre.get(k) - edge.get(k) != diff1 || pre.get(k+1) - edge.get(k+1) != diff2) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) edges.add(edge);
                }
            }
        }
        return edges.size();
    }

    private void dfs(int[][] grid, int i, int j, List<Integer> edge) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;

        grid[i][j] = 0;
        edge.add(i);
        edge.add(j);
        dfs(grid, i+1, j, edge);
        dfs(grid, i-1, j, edge);
        dfs(grid, i, j+1, edge);
        dfs(grid, i, j-1, edge);
    }

    public static void main(String[] a) {
        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        System.out.println(new numberOfDistinctIslands().numDistinctIslands(grid));
    }
}
