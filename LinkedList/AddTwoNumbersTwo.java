package LinkedList;

import java.util.Stack;

public class AddTwoNumbersTwo {
    // now there is another solution, without reversing the LLs
    // we have to store the elements of voth in two stacks and then perform the same
    // steps like before
    // TC : N
    // SC : N
    static ListNode sol2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        int carry = 0;
        ListNode ans = new ListNode();

        while (!s1.isEmpty() || !s2.isEmpty()) {

            if (!s1.isEmpty()) {
                sum += s1.pop();
            }

            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            ans.val = sum % 10;
            carry = sum / 10;

            ListNode temp = new ListNode(carry);
            temp.next = ans;
            ans = temp;
            sum = carry;

        }

        return carry == 0 ? ans.next : ans;
    }

    // TC : N
    // SC : 1
    static ListNode sol1(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        int sum = 0;
        int carry = 0;
        ListNode ans = new ListNode();

        while (l1 != null || l2 != null) {

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            ans.val = sum % 10;
            carry = sum / 10;
            ListNode temp = new ListNode(carry);
            temp.next = ans;
            ans = temp;
            sum = carry;
        }

        return carry == 0 ? ans.next : ans;
    }

    // reverse both the lists and add the elements one by one,
    // maintaining carry value
    // TC : N
    // SC : O(N), returning new list
    static ListNode solution(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode head = new ListNode(-1);
        ListNode node = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            node.next = temp;
            node = node.next;
        }
        return reverse(head.next);
    }

    static ListNode reverse(ListNode head) {
        ListNode low = null;
        ListNode mid = head;
        while (mid != null) {
            ListNode high = mid.next;
            mid.next = low;
            low = mid;
            mid = high;
        }
        return low;
    }
}
