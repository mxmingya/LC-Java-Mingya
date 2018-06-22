package ArraysStackQueue;
import java.util.*;

public class OddEvenLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    public ListNode oddEvenList(ListNode head) {
        // maintain 2 pointers and remember to
        if (head == null) return head;
        ListNode odd = head, even = head.next, evenRes = even;
        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenRes;
        return head;
    }
}
