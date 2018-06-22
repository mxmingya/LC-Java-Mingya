package Tree;

/**
 * Created by mingyama on 10/14/17.
 */
public class LongestUnivalueTree {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root, null);
        return max;
    }

    //    5
    //  4    5
    // 1  3    5
    // since the final answer is depends on the previous node ,we need to do post order traversal,
    // post order traversal keeps the previous values in left and right
    private int dfs(TreeNode root, Integer pre) {
        if (root == null) return 0;
        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        max = Math.max(max, left + right);
        System.out.printf("root:%d, left:%d, right:%d, pre:%d\n",  root.val, left, right, pre);
        if (pre != null && pre == root.val) {
            return Math.max(left, right) + 1;
        }
        return  0;
    }

    public static void main(String[] a) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(5);
        n1.left = n2; n1.right = n3;
        n2.left=n4;n2.right=n5; n3.right=n6;
        System.out.println(new LongestUnivalueTree().longestUnivaluePath(n1));

    }
}
