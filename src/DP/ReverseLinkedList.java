package DP;

/**
 * Created by mingyama on 9/7/17.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode pre = null; // a third pointer used to substitute the previous pointer.

        if (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    private ListNode reverseList(ListNode head, ListNode pre) {
        if (head == null) return pre;
        ListNode temp = head.next;
        head.next = pre;
        return reverseList(temp, head);
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ReverseLinkedList test = new ReverseLinkedList();
        System.out.println(test.reverseList(n1).val);
    }
}
