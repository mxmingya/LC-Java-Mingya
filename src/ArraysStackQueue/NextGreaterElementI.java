package ArraysStackQueue;
import java.util.*;
public class NextGreaterElementI {
    class Solution {
        public int[] nextGreaterElement(int[] findNums, int[] nums) {
            //  利用stack只能看到目前最后一个元素的性质，找到下一个比他大的元素
            // 如果一直都是递减的数列，一直放进stack里面，
            // 如果出现任何一个元素比现在stack最上面的元素大，
            // 那么我们就知道这个元素就是stack最上面元素的greater elemen
            if (findNums == null || nums == null) return new int[0];
            Map<Integer, Integer> numToNxtGreat = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for (int num : nums) {
                while (!stack.isEmpty() && stack.peek() < num) {
                    numToNxtGreat.put(stack.pop(), num);
                }
                stack.push(num);
            }
            for (int i = 0; i < findNums.length; i++) {
                findNums[i] = numToNxtGreat.getOrDefault(findNums[i], -1);
            }
            return findNums;
        }
        //  [4,1,2], [1,3,4,2],
        //  map: 1:3, 3:4,
        // stack: 4, 2
    }
}
