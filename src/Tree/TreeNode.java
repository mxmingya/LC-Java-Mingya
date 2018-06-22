package Tree;
import java.util.List;
import java.util.LinkedList;
/**
 * Created by mingyama on 8/31/17.
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public List<TreeNode> children;

    public TreeNode(int val) {
        this.val = val;
        this.children = new LinkedList<>();
    }
}
