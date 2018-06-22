package FB;
import java.util.*;
/**
 * Created by mingyama on 10/28/17.
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        k = Math.abs(k);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            if (map.containsKey(sum)) {
                if (i-map.get(sum) > 1) return true;
            }
            else {
                map.put(sum, i);
            }
        }
        return false;
    }
    public static void main(String[] a) {
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{23,2,4,6,7}, 6));
    }
}
