package Tree;
import java.util.*;

/**
 * Created by mingyama on 10/12/17.
 */
public class PopulatingNextRightPointersInEachNodeII {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        if (root == null ) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeLinkNode> temp = new LinkedList<>();
            for (int i =0; i < size; i++) {
                TreeLinkNode cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                    temp.add(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                    temp.add(cur.right);
                }
            }
            for (int i =1; i<temp.size(); i++) {
                temp.get(i-1).next = temp.get(i);
            }
            if (temp.size() > 0) {
                temp.get(temp.size()-1).next = null;
            }
        }
    }

    public void connect_(TreeLinkNode root) {
        if (root == null) return;
        Map<Integer, TreeLinkNode> map = new HashMap<>();
        dfs(root, map, 0);
//        for (TreeLinkNode n : map.values()) {
//            if (n != null) n.next = null;
//        }
    }
    //    1
    //  2   3
    // 4 5   7

    public void dfs(TreeLinkNode root, Map<Integer, TreeLinkNode> map, int level) {
        if (root == null) return;
        if (!map.containsKey(level)) {
            map.put(level, root);
        }
        else {
            TreeLinkNode pre = map.get(level);
            pre.next = root;
            map.put(level, root);
            root.next = null;
        }

        dfs(root.left, map, level+1);
        dfs(root.right, map, level+1);
    }

    public static void main(String[] a) {
        TreeLinkNode root  =  new TreeLinkNode(1);
        TreeLinkNode root1 = new TreeLinkNode(2);
        TreeLinkNode root2 = new TreeLinkNode(3);
        root.left = root1;
        root.right = root2;
        new PopulatingNextRightPointersInEachNodeII().connect_(root);
        System.out.printf("%d next is %s\n", root.val, root.next);
        System.out.printf("%d next is %s\n", root1.val, root1.next);
        System.out.printf("%d next is %s\n", root2.val, root2.next);

    }

}
