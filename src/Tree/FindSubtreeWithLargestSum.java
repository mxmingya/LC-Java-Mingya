package Tree;

/**
 * Created by mingyama on 10/25/17.
 */
public class FindSubtreeWithLargestSum {
    int max = Integer.MIN_VALUE;
    Integer rootVal = null;

    public TreeNode findsum(TreeNode root) {
        if (root == null) return null;

        helper(root);
        return rootVal == null ? null : new TreeNode(rootVal);
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, Math.max(left, right));
        rootVal = root.val;
        return root.val + left + right;
    }
}
