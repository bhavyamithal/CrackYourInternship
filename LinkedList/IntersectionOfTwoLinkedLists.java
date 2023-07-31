package LinkedList;

public class IntersectionOfTwoLinkedLists {
    // another approach is to take dummy nodes for both the lists and the traverse
    // them
    // when one of them reaches the end (null) set them back to the other list`s
    // head
    // i.e. if node1 reaches null then set it back to the head2
    // i.e. if node2 reaches null then set it back to the head1
    // by doing this they will be aligned at the same position before the
    // intersection
    // and then when we traverse again they will become equal, either at
    // intersection point (if there exists one) or at null (if there is no
    // intersection)
    // TC : O(N)
    // SC : O(1)
    static ListNode optimal(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {

            if (node1 != null) {
                node1 = node1.next;
            } else {
                node1 = headB;
            }

            if (node2 != null) {
                node2 = node2.next;
            } else {
                node2 = headA;
            }

        }
        return node1;
    }

    // another approach is to find the length of both the lists
    // then find the difference, then move the longer list node by the distance, so
    // that they come at equal position before the intersection
    // and then when we start moving them simultaneously, we will return the node
    // when they will become equal
    // TC : O(M)
    // SC : O(1)
    static ListNode better(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        int len1 = 0;
        while (node1 != null) {
            len1++;
            node1 = node1.next;
        }

        ListNode node2 = headB;
        int len2 = 0;
        while (node2 != null) {
            len2++;
            node2 = node2.next;
        }

        node1 = headA;
        node2 = headB;
        int difference = Math.abs((len1 - len2));

        if (len1 < len2) {
            while (difference != 0) {
                node2 = node2.next;
                difference--;
            }
        } else {
            while (difference != 0) {
                node1 = node1.next;
                difference--;
            }
        }

        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

    // another approach can be HASHING but it uses O(N) memory, and O(N) time

    // for every node in list 1, we are checking every other node in list2
    // TC : M * N
    // SC : 1
    static ListNode bruteforce(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != null) {
            node2 = headB;
            while (node2 != null) {
                if (node1 == node2)
                    return node1;
                node2 = node2.next;
            }
            node1 = node1.next;
        }
        return null;
    }
}
