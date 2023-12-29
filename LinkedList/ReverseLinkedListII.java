package LinkedList;

public class ReverseLinkedListII {
    // create a dummy node and prev pointing to dummy
    // move start (left - 1) times from the head, prev sholud point to (start - 1) node
    // move end (right - 1) times from head, then prev.next = end
    // low = end.next and then keep reversing until low != end
    // return dummy.next
    static ListNode reverse(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode start = head;
        while (left > 1) {
            prev = start;
            start = start.next;
            left--;
        }
        ListNode end = head;
        while (right > 1) {
            end = end.next;
            right--;
        }
        prev.next = end;

        ListNode low = end.next;

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
