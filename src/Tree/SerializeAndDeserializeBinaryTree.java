package Tree;
import java.util.*;

/**
 * Created by mingyama on 10/12/17.
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    final String termination = "NULL";
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(termination).append(",");
            return;
        }
        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        Collections.addAll(nodes, data.split(","));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String cur = nodes.poll();
        if (cur.equals("NULL") || cur.length() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }

    public static void main(String[] a ) {
    }

}
