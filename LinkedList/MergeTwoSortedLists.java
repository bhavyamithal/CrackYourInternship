package LinkedList;

public class MergeTwoSortedLists {
    static ListNode merge(ListNode list1, ListNode list2) {
        ListNode curr = new ListNode(-1);
        ListNode head = curr;

        while (list1 != null && list2 != null) {
            int value1 = list1.val;
            int value2 = list2.val;
            if (value1 < value2) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null)
            curr.next = list1;
        if (list2 != null)
            curr.next = list2;

        return head.next;
    }
}
