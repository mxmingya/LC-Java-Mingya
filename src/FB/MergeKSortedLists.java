package FB;
import java.util.*;

/**
 * Created by mingyama on 10/24/17.
 */
public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare (ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode root = lists[i];
            // queue.add(root);
            if (root != null) queue.add(root);
        }
        ListNode root = new ListNode(0);
        ListNode dummy = root;

        while (!queue.isEmpty()) {
            root.next = queue.poll();
            root = root.next;

            if (root.next != null) queue.add(root.next);
        }
        return dummy.next;
    }
}
