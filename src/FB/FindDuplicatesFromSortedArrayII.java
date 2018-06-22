package FB;
import java.util.*;
/**
 * Created by mingyama on 10/26/17.
 */
public class FindDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int lastValid = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            // i is first time
            if ( nums[i] != nums[i-1]) {
                count = 1;
            } else if (nums[i] == nums[i-1]) {

            }
            // i is second time
            else if (map.get(nums[i]) == 1) {
                map.put(nums[i], 2);
                nums[lastValid] = nums[i];
                lastValid++;
            }
        }

        return lastValid;
    }
}
