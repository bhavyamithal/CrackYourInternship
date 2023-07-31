package LinkedList;

public class RemoveDuplicatesFromSortedList {
    static ListNode deleteDuplicates(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        while (left != null) {
            while (right != null && left.val == right.val) {
                right = right.next;
            }
            left.next = right;
            left = right;                
        }
        return head;
    }
}
