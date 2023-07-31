package LinkedList;

public class MultiplyTwoLinkedLists {
    static long multiply(ListNode l1, ListNode l2) {
        long N = 1000000007;
        // calc num1
        long num1 = 0;
        while (l1 != null) {
            num1 = (num1 * 10) % N;
            num1 = num1 + l1.val;
            l1 = l1.next;
        }
        // calc num2
        long num2 = 0;
        while (l1 != null) {
            num2 = (num2 * 10) % N;
            num2 = num2 + l2.val;
            l2 = l2.next;
        }
        return ((num1 % N) * (num2 % N)) % N;
    }
}
