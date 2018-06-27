package ArraysStackQueue;

public class ReverseLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
            this.next = null;
        }
    }
    ListNode pre = null;
    public ListNode reverseList(ListNode head) {
        // 1 2 3 4 5
        // 2 1 3 4 5
        while (head != null) {
            ListNode temp = head.next;// 2
            head.next = pre; // 1->3
            pre = head;
            head = temp; // 2
        }
        return pre;
    }
}
