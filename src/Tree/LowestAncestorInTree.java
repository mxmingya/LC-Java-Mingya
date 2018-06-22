package Tree;
import java.util.*;
/**
 * Created by mingyama on 10/15/17.
 */
public class LowestAncestorInTree {

    public TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        Map<TreeNode, List<TreeNode>> parents = new HashMap<>();
        findParents(root, parents, new LinkedList<>());
        return null;
    }

    private void findParents(TreeNode root, Map<TreeNode, List<TreeNode>> parents, List<TreeNode> cur) {

    }


}
