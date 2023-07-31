package LinkedList;

public class LinkedListCycle {
    static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast && fast != null && fast.next != null);

        if (slow == fast) return true;
        return false;
    }
}
