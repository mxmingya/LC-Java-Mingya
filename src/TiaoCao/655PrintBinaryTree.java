/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // this question is pretty similar to the question where sort the tree nodes by columns. 
 // the key is the borders and compute the index correctly. 
class Solution {
    public List<List<String>> printTree(TreeNode root) {
      if (root == null) return null;
      List<List<String>> res = new LinkedList<>();
      Queue<TreeNode> q = new LinkedList<>();
      int height = getHeight(root);
      int row = height, col = (int) Math.pow(2, height)-1;
      for (int i = 0; i < row; i++) {
        List<String> temp = new LinkedList<>();
        for (int j = 0; j < col; j++) {
          temp.add("");
        }
        res.add(temp);
      }
      helper(root, 0, row, 0, col, res);
      return res;
    }
  
    private void helper(TreeNode root, int row, int rowNum, int col, int colNum, List<List<String>> res) {
      if (root == null || row > rowNum || col > colNum) return;
      int curPosi = (col + colNum) / 2;
      System.out.println(row);
      List temp = res.get(row);
      temp.set(curPosi, Integer.toString(root.val));
      helper(root.left, row+1, rowNum, col, curPosi-1, res);
      helper(root.right, row+1, rowNum, curPosi+1, colNum, res);
    } 
    
    private int getHeight(TreeNode root) {
      if (root == null) return 0;
      return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
  }