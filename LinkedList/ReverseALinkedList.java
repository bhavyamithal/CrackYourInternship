package LinkedList;

public class ReverseALinkedList {
    static ListNode reverse(ListNode head) {
        if (head == null) return head;
        ListNode low = null;
        ListNode mid = head;
        ListNode high = head.next;

        while (mid != null) {
            mid.next = low;
            low = mid;
            mid = high;
            if (high != null)
                high = high.next;
        }

        head = low;
        return head;
    }
}
