package LinkedList;

public class DeleteNodesHavingGreaterValueOnRight {
    // 12 15 10 11 5 1 2 3
    // reverse the list
    // iterate the list, and delete any elements which are less tha maxRight
    // reverse the list back again
    // return the head
    static ListNode solution1(ListNode head) {
        if (head.next == null)
            return head;
        head = reverse(head);
        int maxRight = head.val;
        ListNode curr = head.next;
        ListNode prev = head;
        while (curr != null) {
            while (curr != null && curr.val < maxRight) {
                curr = curr.next;
            }
            if (curr == null) {
                prev.next = null;
                break;
            }
            prev.next = curr;
            prev = prev.next;
            maxRight = curr.val;
            curr = curr.next;
        }
        head = reverse(head);
        return head;
    }

    static ListNode reverse(ListNode head) {
        ListNode low = null;
        ListNode mid = head;
        ListNode high = mid.next;
        while (mid != null) {
            mid.next = low;
            low = mid;
            mid = high;
            if (high != null) {
                high = high.next;
            }
        }
        head = low;
        return head;
    }
}
