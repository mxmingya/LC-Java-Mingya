package Tree;

/**
 * Created by mingyama on 10/30/17.
 */
public class SymmatricTree {
    public boolean symmatric(TreeNode root) {
        if (root == null ) return false;

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if (q == null || p == null) return q == p;

        if (q.val != p.val) return false;
        return helper(p.left, q.right) && helper(p.right, q.left);
    }

}
