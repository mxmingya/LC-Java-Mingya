/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    int res = 0;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        helper(root, 1);
        return res;
    }
    
    private void helper(Node root, int dep) {
        if (root == null) return;
        res = Math.max(dep, res);
        for (Node child : root.children) {
            
            helper(child, dep+1);
        }
    }
}