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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        res.add(root.val);
        dfs(root, res);
        return res;
    }
    
    private void dfs(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node child : root.children) {
            res.add(child.val);
            dfs(child, res);
        }
    }
}