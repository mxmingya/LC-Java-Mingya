package FB;
import java.util.*;
import Tree.*;
/**
 * Created by mingyama on 10/31/17.
 */
public class convertSortedListToBinarySearchTree {
    public static class ListNode {
        // LinkedList Class

        ListNode next;
        int val;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        //1,2,3,4,5
        //     3
        //   2   4
        //  1      5
        if (head == null) return null;
        List<Integer> nums = new ArrayList<>();
        while (head != null ) {
            nums.add(head.val);
            head = head.next;
        }

        TreeNode root = helper(nums, 0, nums.size()-1);
        return root;
    }

    private TreeNode helper(List<Integer> nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);
        return root;
    }
    public TreeNode sortedListToBST__(ListNode head) {
        //1,2,3,4,5
        //     3
        //   2   4
        //  1      5
        return helper(head, null);
    }

    private TreeNode helper(ListNode start, ListNode end) {
        ListNode fast = start;
        ListNode slow = start;
        if (start == end) return null;


        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        } // find mid point

        TreeNode root = new TreeNode(slow.val);
        root.left = helper(start, slow);
        root.right = helper(slow.next, end);
        return root;
    }

    public static void main(String[] a) {
        ListNode head = new ListNode(0);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(2);
        head.next = p2;
        head.next.next = p3;
        System.out.println(new convertSortedListToBinarySearchTree().sortedListToBST(head).val);
    }
}
