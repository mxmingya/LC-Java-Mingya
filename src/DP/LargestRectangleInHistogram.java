package DP;

import java.util.Stack;

/**
 * Created by mingyama on 9/8/17.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int current = (i == height.length) ? -1 : height[i];
            System.out.print("current: ");
            System.out.print(current);
            while (!stack.isEmpty() && current <= height[stack.peek()]) {
                int h = height[stack.pop()];
                if (!stack.isEmpty()){ System.out.print(" peek:");
                    System.out.print(stack.peek());}
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                System.out.print(" width: ");
                System.out.print(w);
                max = Math.max(max, h * w);
            }
            System.out.println("");
            stack.push(i);
        }

        return max;
    }

    public static void main(String[] a) {
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        System.out.println(test.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
