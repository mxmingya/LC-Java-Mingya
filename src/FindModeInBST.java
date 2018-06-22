/**
 * Created by mingyama on 8/31/17.
 */
import Tree.TreeNode;

import java.util.*;

public class FindModeInBST {


    public int[] findMode(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        HashMap<Integer, Integer> node2Freq = new HashMap<>();
        List<Integer> nodes = new LinkedList<>();
        int max = 0;
        while (!st.isEmpty()) {
            TreeNode currentNode = st.pop();
            System.out.println(currentNode.val);
            node2Freq.put(currentNode.val, node2Freq.getOrDefault(currentNode.val, 0)+1);
            max = Math.max(node2Freq.get(currentNode.val), max);
            if (currentNode.left != null) st.push(currentNode.left);
            if (currentNode.right != null) st.push(currentNode.right);
        }

        for (int key : node2Freq.keySet()) {
            if (node2Freq.get(key) == max) {
                nodes.add(key);
            }
        }

        int[] res = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            res[i] = nodes.get(i);
        }
        res[0] = max;
        return res;
    }
    public List<Integer> largestValues(TreeNode root) {
        // do a level order traverse.

        if (root == null) return null;

        List<Integer> maxes = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            List<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                temp.add(tempNode.val);
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            maxes.add(Collections.max(temp));
        }

        return maxes;
    }
    public static void main(String[] args) {
        FindModeInBST test = new FindModeInBST();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(2);
        n1.left = null;
        n1.right = n2;
        n2.left = n3;
//        test.(n1);
    }

}
