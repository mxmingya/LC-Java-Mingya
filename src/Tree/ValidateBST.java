package Tree;

/**
 * Created by mingyama on 10/13/17.
 */
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        // in order traversal
        if (root == null) return true;
        return dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean dfs(TreeNode root, Integer min, Integer max) {
        if (root == null ) return true;
        if (min != Integer.MAX_VALUE && root.val <= min) return false;
        if (max != Integer.MIN_VALUE && root.val >= max) return false;
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}
