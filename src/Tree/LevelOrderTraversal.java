package Tree;
import java.util.*;
import Tree.TreeNode;
/**
 * Created by mingyama on 10/12/17.
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null ) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(temp);
        }
        return res;
    }

    public List<List<Integer>> levelOrder_recursive(TreeNode root) {
        List<List<Integer>> res= new LinkedList<>();
        dfs(root, 0, res);
        return res;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null ) return;
        if (res.size() == level) {
            List<Integer> temp = new LinkedList<>();
            temp.add(root.val);
            res.add(temp);
            return;
        }
        res.get(level).add(root.val);
        dfs(root.left, level+1, res);
        dfs(root.right, level+1, res);
    }
 }
