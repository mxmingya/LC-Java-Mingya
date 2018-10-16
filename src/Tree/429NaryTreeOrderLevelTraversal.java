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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                temp.add(cur.val);
                for (Node child : cur.children) {
                    q.add(child);
                }
            }
            list.add(temp);
        }
        return list;
    }
}