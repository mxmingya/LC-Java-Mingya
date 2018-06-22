package DP;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by mingyama on 9/7/17.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            int curLeftBoundary =0, curRightBoundary = n;
            for (int j = 0; j < n; j++) {
                //compute height
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < n; j++) { // compute the left boundary
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], curLeftBoundary);
                else {
                    left[j] = 0;
                    curLeftBoundary = j + 1; // j+1 because of index + 1 = real position
                }
            }
            for (int j = n-1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRightBoundary);
                }
                else {
                    right[j] = n;
                    curRightBoundary = j; // j because j has already equal to index
                }
            }

            //find the largest areas
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j]-left[j]) * height[j]);
            }

            System.out.println("left");
            for (int j = 0; j < n; j++) {
                System.out.print(left[j]);
            }
            System.out.println("");
            System.out.println("right");
            for (int j = 0; j < n; j++) {
                System.out.print(right[j]);
            }
            System.out.println("");
            System.out.println("height");
            for (int j = 0; j < n; j++) {
                System.out.print(height[j]);
            }
            System.out.println("");
        }
        return maxArea;
    }

    public int way2(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            //scan row by row
            System.out.println("way2 index: ");
            System.out.println(i);
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += Character.getNumericValue(matrix[i][j]);
                }
            }

            max = Math.max(max, LargestRectangleinHistogram(heights));
        }
        return max;
    }

    private int LargestRectangleinHistogram(int[] heights) {
        int max = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int current = i == heights.length ? -1 : heights[i];
            System.out.println("helper index: ");
            System.out.println(i);
            while (!s.isEmpty() && heights[s.peek()] >= current) {
                int height = heights[s.pop()];
                int width = s.isEmpty() ? i : i - s.peek() - 1;
                max = Math.max(max, height * width);
            }

            s.push(i);
        }
        return max;
    }


    public static void main(String[] a) {
        MaximalRectangle test = new MaximalRectangle();
        System.out.println(test.way2(new char[][]{
                "10100".toCharArray(),"10111".toCharArray(),"11111".toCharArray(),"10010".toCharArray(),
        }));


    }

}
