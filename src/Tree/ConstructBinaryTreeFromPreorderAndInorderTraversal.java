package Tree;

/**
 * Created by mingyama on 10/14/17.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, 0, inorder.length-1);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int preIndex, int left, int right) {
        if (preIndex > preorder.length - 1 || left > right) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        int i;
        for (i = left; i <= right; i++) {
            if (inorder[i] == preorder[preIndex]) {
                break;
            }
        }
        root.left = construct(preorder, inorder, preIndex + 1, left, i-1);
        root.right = construct(preorder, inorder, preIndex + i - left + 1, i+1, right);
        return root;
    }
}
