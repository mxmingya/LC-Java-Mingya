package Tree;
import java.util.*;
/**
 * Created by mingyama on 10/13/17.
 */
public class InorderSuccessorBST {
    //    5
    //  3    7
    // 1 4  6  9   p = 7, return 6
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        // in order traversal
        Stack<TreeNode> stack = new Stack<>();
        boolean flag = false;
        while (root != null || !stack.isEmpty()) {
//            System.out.printf("stack size: %d, ", stack.size());
           if (root != null) {
               stack.push(root);
               root = root.left;
           } else {
               // to the end of left children
               root = stack.pop();
               if (flag) {
                   return root;
               }
               if (root.val == p.val) {
                   flag = true;
               }
               root = root.right;
           }

        }
        return null;
    }

    private TreeNode inorderAncestor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        TreeNode ancestor = null;
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            if (root != null) {
                st.push(root);
                ancestor = root;
                root = root.left;
            }
            else {
                root = st.pop();
                if (root.val == p.val) return ancestor;
                ancestor = root;
                root = root.right;
            }
        }
        return null;
    }

    public static void main(String[] a) {
        TreeNode p1 = new TreeNode(6);
        TreeNode p2 = new TreeNode(3);
        TreeNode p3 = new TreeNode(7);
        TreeNode p4 = new TreeNode(1);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(8);
        TreeNode p7 = new TreeNode(2);
        TreeNode p8 = new TreeNode(4);
        p1.left = p2;
        p1.right = p3;
        p2.left = p4;
        p2.right = p5;
        p3.right = p6;
        p4.right = p7;
        p5.left = p8;
        System.out.println(new InorderSuccessorBST().inorderSuccessor(p1, p6));
        System.out.println(new InorderSuccessorBST().inorderAncestor(p1, p6).val);
    }
}
