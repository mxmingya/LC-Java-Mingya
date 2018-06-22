package SortSearch;

/**
 * Created by mingyama on 10/25/17.
 */
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length-1;

        while (left < right) {
            int mid = left + (right -left) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] > target && target <= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (nums[left] == target) return left;
        return -1;
    }

    public boolean search2(int[] nums, int target) {
        return false;
    }

    public static void main(String[] a) {
        System.out.println(new SearchInRotatedArray().search(new int[] {3,1}, 1));
    }
}
