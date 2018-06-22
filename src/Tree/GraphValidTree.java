package Tree;

/**
 * Created by mingyama on 10/25/17.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return true;
        // union find.
        // [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
        // n = -1 -1 -1 -1 -1
        // find(0), find(1)
        // there is n nodes so we need n-1 edges
        if (edges.length != n-1) return false;
        int[] unions = new int[n];
        // unions.fill(unions, -1);

        for (int i = 0; i < edges.length; i++) {
            int x = find(unions, edges[i][0]);
            int y = find(unions, edges[i][1]);

            if (x == y) return false;

            unions[x] = y;
        }

        return true;
    }

    private int find(int[] nums, int index) {
        if (nums[index] == 0) return index; // no union
        return find(nums, nums[index]);
    }
}
