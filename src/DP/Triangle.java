package DP;
import java.util.*;
/**
 * Created by mingyama on 10/6/17.
 */
public class Triangle {
    //2
    //3 4
    //6,5,7
    //4,1,8,3
    public int minimumTotal_slow(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int len = triangle.size();
        int[][] currentMin = new int[len][len];
        for (int[] arr : currentMin) {
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                currentMin[i][j] = triangle.get(i).get(j);
                if (i == 0 && j == 0) continue;
                if (j == 0) currentMin[i][j] += currentMin[i-1][j];
                else if ( j == i) {
                    currentMin[i][j] += currentMin[i-1][j-1];
                } else {
                    currentMin[i][j] += Math.min(currentMin[i-1][j], currentMin[i-1][j-1]);
                }
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            minSum = Math.min(minSum, currentMin[len-1][i]);
        }
        return minSum;
    }

    private int minimumTotal_ok(List<List<Integer>> triangle) {
        // need more work...
        int len = triangle.size();

        int[] min = new int[triangle.get(len).size()];
        min[0] = triangle.get(0).get(0);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < triangle.get(len).size(); j++) {
                 min[i] = Math.min(min[i-1], min[i]) + triangle.get(i).get(j);
            }
        }
        int minSum = 0;
        for (int i : min) {
            minSum = Math.min(minSum, i);
        }
        return minSum;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] min = new int[triangle.get(len-1).size()];
        for (int i = len-2; i>= 0; i--) {
            for (int j = i; j >= 0; j--) {
                min[j] = Math.min(min[j], j == 0 ? min[j] : min[j-1]) + triangle.get(i).get(j);
            }
        }
        return min[0];
    }

    public static void main(String[] a) {

    }
}
