package LinkedList;

public class PartitionList {
    // TC:N
    // SC:1
    static ListNode sol2(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode leftTail = left, rightTail = right;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                leftTail.next = curr;
                leftTail = leftTail.next;
            } else {
                rightTail.next = curr;
                rightTail = rightTail.next;
            }
            curr = curr.next;
        }
        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }

    // below solution does not preserve the relative order of elements
    static ListNode sol(ListNode head, int x) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val < x) {
                prev.next = curr.next;
                curr.next = dummy.next;
                dummy.next = curr;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
