package BackTracking;
import java.util.*;

/**
 * Created by mingyama on 9/25/17.
 */
public class SubsetsII {
    public List<List<Integer>> subsets(int[] nums) {
        // input contains duplicates, eg: [1,1,2,3]
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, res, new LinkedList<Integer>(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        if (!res.contains(list)) {
            res.add(new ArrayList<Integer>(list));
        } else {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, res, list, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] agrs) {

        for (List<Integer> list : new SubsetsII().subsets(new int[] {1,2,2})) {
            for (int i : list) {
                System.out.printf("%d", i);
            }
            System.out.println("");
        }
//        System.out.println("--------------");
//        for (List<Integer> list : new SubsetsII().subsets(new int[] {1,2,2,2,2,3,4})) {
//            for (int i : list) {
//                System.out.printf("%d", i);
//            }
//            System.out.println("");
//        }
    }
}
