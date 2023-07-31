package LinkedList;

public class MergeSort {
    static ListNode mergesort(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode mid = findmid(head);
        ListNode head2 = mid.next;
        mid.next = null;

        ListNode newHead1 = mergesort(head);
        ListNode newHead2 = mergesort(head2);

        ListNode finalHead = merge(newHead1, newHead2);

        return finalHead;
    }

    static ListNode merge(ListNode head1, ListNode head2) {
        ListNode merged = new ListNode(-1);
        ListNode temp = merged;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // while head1 is not null
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        // while head2 is not null
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return merged.next;
    }

    static ListNode findmid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // cos i want the first mid

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
