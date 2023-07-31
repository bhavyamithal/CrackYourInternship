package LinkedList;

public class ConvertBinaryNumberInALinkedListToInteger {
    static int optimal(ListNode head) {
        ListNode temp = head;
        int ans = 0;
        while (temp != null) {
            ans *= 2;
            ans += temp.val;
            temp = temp.next;
        }
        return ans;
    }


    static int bruteforce(ListNode head) {
        ListNode node = head;
        int size = 1;
        while (node.next != null) {
            node = node.next;
            size++;
        }
        node = head;
        int num = 0;
        while (node != null) {
            size--;
            num = num + (node.val * (int)(Math.pow(2, size)));
            node = node.next;
        }
        return num;
    }
}
