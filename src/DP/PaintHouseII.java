package DP;

/**
 * Created by mingyama on 9/12/17.
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int m1 = -1, m2 = -1;
        for (int i = 0; i < costs.length; i++) {
            int last1 = m1, last2 = m2;
            m1 = -1; m2 = -1;
            for (int j = 0; j < costs[0].length; j++) {
                // check if current house is the last time Min, if yes, update the current cost with second last min, otherwise update it with the last min.
                if (last1 != j) {
                    costs[i][j] += last1 == -1 ? 0 : costs[i-1][last1];
                } else {
                    costs[i][j] += last2 == -1 ? 0 : costs[i-1][last2];
                }

                //find the last min and second last min in this round.
                if (m1 == -1 || costs[i][j] < costs[i][m1] ) {
                    m2 = m1;
                    m1 = j;
                } else if (m2 == -1 || costs[i][j] < costs[i][m2]) {
                    m2 = j;
                }
            }
        }
        return costs[costs.length-1][m1];
    }
    // lastMin: 0,
    // secMin: -1,

    public static void main(String[] args) {
        System.out.println(new PaintHouseII().minCostII(new int[][]{{20,19,11,13,12,16,16,17,15,9,5,18},{3,8,15,17,19,8,18,3,11,6,7,12},{15,4,11,1,18,2,10,9,3,6,4,15}}));
    }
}
