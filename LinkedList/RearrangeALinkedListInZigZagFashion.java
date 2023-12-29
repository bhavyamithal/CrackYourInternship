package LinkedList;

public class RearrangeALinkedListInZigZagFashion {
    static ListNode zigZagRecursive(ListNode node, int flag) {
        
        if (node == null || node.next == null) {
            return node;
        }

        if (flag == 1) {

            if (node.val < node.next.val) {
                // swap data
                int temp = node.val;
                node.val = node.next.val;
                node.next.val = temp;
            }
            return zigZagRecursive(node.next, 0);

        } else {

            if (node.val > node.next.val) {
                // swap data
                int temp = node.val;
                node.val = node.next.val;
                node.next.val = temp;
            }
            return zigZagRecursive(node.next, 1);

        }

    }

    // maintain a flag for representing which order () currently we are. If the
    // current two elements are not in that order then swap those elements otherwise
    // not
    static ListNode zigZagIterative(ListNode head) {

        boolean flag = true;
        // if flag = true, then next element should be greater
        // if flag = false, then next element should be smaller

        ListNode curr = head;

        while (curr.next != null) {

            if (flag) {

                if (curr.val > curr.next.val) {
                    // swap data values
                    int temp = curr.val;
                    curr.val = curr.next.val;
                    curr.next.val = temp;
                }

            } else {

                if (curr.val < curr.next.val) {
                    int temp = curr.val;
                    curr.val = curr.next.val;
                    curr.next.val = temp;
                }

            }

            curr = curr.next;
            flag = !(flag);

        }

        return head;

    }

    // approach 1 : sort it using mergeSort, then swap the alternate elements in a
    // zig-zag fashion
    static ListNode sol1(ListNode head) {
        head = mergeSort(head);

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode curr = head.next;
        ListNode next = curr.next;

        while (next != null) {
            // swap data values
            int temp = curr.val;
            curr.val = next.val;
            next.val = temp;
            if (next.next == null || next.next.next == null) {
                break;
            }
            curr = next.next;
            next = next.next.next;
        }

        return head;
    }

    static ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;

        ListNode newHead1 = mergeSort(head);
        ListNode newHead2 = mergeSort(head2);

        ListNode finalHead = merge(newHead1, newHead2);

        return finalHead;
    }

    static ListNode merge(ListNode head1, ListNode head2) {
        ListNode merged = new ListNode();
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

        while (head1 != null) {
            temp.next = head1;
            temp = temp.next;
            head1 = head1.next;
        }

        while (head2 != null) {
            temp.next = head2;
            temp = temp.next;
            head2 = head2.next;
        }

        return merged.next;
    }

    static ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
