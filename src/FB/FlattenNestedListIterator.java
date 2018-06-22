package FB;
import java.util.*;
import FB.NestedIterator.*;
/**
 * Created by mingyama on 10/28/17.
 */



public class FlattenNestedListIterator {
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         public TreeNode(int val) {
             this.val = val;
             this.left = null;
             this.right = null;
         }

    }
    public class NestedIterator implements Iterator<Integer> {
        Stack<TreeNode> st;
        public NestedIterator(List<NestedInteger> nestedList) {
            st = new Stack<>();

        }

        @Override
        public Integer next() {
            return 0;
        }

        @Override
        public boolean hasNext() {
            return false;
        }
    }
}
