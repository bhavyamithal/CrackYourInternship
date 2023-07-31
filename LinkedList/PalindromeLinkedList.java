package LinkedList;

public class PalindromeLinkedList {
    static boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        slow = slow.next;
        ListNode dummy = head;

        while (slow != null) {
            if (slow.val != dummy.val) {
                return false;
            }
            slow = slow.next;
            dummy = dummy.next;
        }

        return true;
    }

    static ListNode reverse(ListNode mid) {
        ListNode low = null;
        ListNode high = mid.next;

        while (mid != null) {
            mid.next = low;
            low = mid;
            mid = high;
            if (high != null) {
                high = high.next;
            }
        }
        
        return low;
    }
}