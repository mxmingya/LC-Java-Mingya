/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      if (root1 == null || root2 == null) return root1 == root2;
      List<Integer> val1 = new LinkedList<>();
      List<Integer> val2 = new LinkedList<>();
      getLeaves(root1, val1);
      getLeaves(root2, val2);
      if (val1.size() != val2.size()) return false;
      for (int i = 0; i < val1.size(); i++) {
        if (val1.get(i) != val2.get(i)) return false;
      }
      return true;
    }
  
  private void getLeaves(TreeNode root, List<Integer> list) {
    if (root.left == null && root.right == null) {
      list.add(root.val);
    }
    if (root.left != null) getLeaves(root.left, list);
    if (root.right != null) getLeaves(root.right, list);
  }
}