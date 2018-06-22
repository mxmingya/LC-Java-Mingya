package ArraysStackQueue;
import java.util.*;
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        // 思路和nextgreaterelementI 的差不多，唯一就是为了解决轮转问题，我们把一份copy过的数放在原input后面，
        // 由于loop之中index并不一定是原inpout的index，所以必须把index放在stack里面。
        int len = nums.length;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2*len; i++) {
            int num = nums[i % len];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < len) {
                stack.push(i);
            }
        }
        return res;
    }
}
