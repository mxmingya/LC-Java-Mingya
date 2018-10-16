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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        dfs(root, res);
        res.add(root.val);
        return res;
    }
    
    private void dfs(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node child : root.children) {
            dfs(child, res);
            res.add(child.val);
        }
    }
}