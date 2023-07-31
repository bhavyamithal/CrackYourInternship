package LinkedList;

public class SortALinkedListOfZeroesOnesAndTwos {
    
    static ListNode sortList(ListNode head) {
        // TC : N
        // SC : 1
        ListNode zeroHead = new ListNode(0);
        ListNode zeroTail = zeroHead;
        ListNode oneHead = new ListNode(0);
        ListNode oneTail = oneHead;
        ListNode twoHead = new ListNode(0);
        ListNode twoTail = twoHead;

        ListNode curr = head;
        while (curr != null) {
            int value = curr.val;
            if (value == 0) {
                zeroTail.next = curr;
                zeroTail = curr;
            } else if (value == 1) {
                oneTail.next = curr;
                oneTail = curr;
            } else {
                twoTail.next = curr;
                twoTail = curr;
            }
            curr = curr.next;
        }

        if (oneHead.next != null) {
            zeroTail.next = oneHead.next;
        } else {
            zeroTail.next = twoHead.next;
        }
        oneTail.next = twoHead.next;
        twoTail.next = null;
        head = zeroHead.next;
        return head;
    }


    // Traverse the list and count the number of 0s, 1s, and 2s. Let the counts be
    // n1, n2, and n3 respectively.
    // Traverse the list again, fill the first n1 nodes with 0, then n2 nodes with
    // 1,and finally n3 nodes with 2.
    // TC : N
    // SC : 1
    static ListNode bruteforce(ListNode head) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        ListNode node = head;
        while (node != null) {
            if (node.val == 0)
                zeroCount++;
            if (node.val == 1)
                oneCount++;
            if (node.val == 2)
                twoCount++;
            node = node.next;
        }
        node = head;
        while (zeroCount != 0) {
            node.val = 0;
            node = node.next;
            zeroCount--;
        }
        while (oneCount != 0) {
            node.val = 1;
            node = node.next;
            oneCount--;
        }
        while (twoCount != 0) {
            node.val = 2;
            node = node.next;
            twoCount--;
        }
        return head;
    }
}
