package LinkedList;

public class SegregateEvenAndOddNodesInALinkedList {
    static ListNode solution(ListNode head) {

        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);

        ListNode leftTail = left, rightTail = right;

        while (head != null) {
            
            if (head.val % 2 == 0) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }

            head = head.next;

        }

        leftTail.next = right.next;
        rightTail.next = null;
        
        return left.next;
    }
}
