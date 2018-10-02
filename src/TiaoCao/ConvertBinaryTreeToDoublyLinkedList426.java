package TiaoCao;
import java.util.*;

public class ConvertBinaryTreeToDoublyLinkedList426 {

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    Node pre = null;
    public Node treeToDoublyList(Node root) {
        if (root == null ) return root;
        Node dummy = new Node(0, null, null);
        pre = dummy;
        dfs(root);
        // pre at the end of the list, dummy still points to the first one's left
        System.out.printf("pre is %d dummy is %d\n", dummy.val, pre.val);
        pre.right = dummy.right;
        dummy.right.left = pre;
        return dummy.right;
    }

    private void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        pre.right = root;
        root.left = pre;
        pre = root;
        dfs(root.right);
    }
}
}
