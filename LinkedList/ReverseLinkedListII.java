package LinkedList;

public class ReverseLinkedListII {
    static ListNode reverse(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode start = head;
        while (left - 1 > 0) {
            prev = start;
            start = start.next;
            left--;
        }
        ListNode end = head;
        while (right - 1 > 0) {
            end = end.next;
            right--;
        }
        prev.next = end;

        ListNode low;
        if (end.next != null) {
            low = end.next;
        } else {
            low = null;
        }

        ListNode mid = start;
        while (low != end) {
            ListNode high = mid.next;
            mid.next = low;
            low = mid;
            mid = high;
        }

        return dummy.next;
    }
}
