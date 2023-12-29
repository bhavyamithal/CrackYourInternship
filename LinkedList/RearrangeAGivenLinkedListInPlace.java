package LinkedList;

public class RearrangeAGivenLinkedListInPlace {
    static ListNode rearrange(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow.next);
        slow.next = null;

        ListNode ans = new ListNode(0);
        ListNode curr = ans;

        while (left != null && right != null) {
            curr.next = left;
            left = left.next;
            curr = curr.next;

            curr.next = right;
            right = right.next;
            curr = curr.next;
        }

        if (left != null) {
            curr.next = left;
        }
        if (right != null) {
            curr.next = right;
        }
        
        return ans.next;
    }

    static ListNode reverse(ListNode mid) {
        ListNode low = null;
        while (mid != null) {
            ListNode high = mid;
            mid.next = low;
            low = mid;
            mid = high;
            high = high.next;
        }
        return low;
    }
}
