package LinkedList;

public class FlattenAMultilevelDoublyLinkedList {
    static Node flatten(Node head) {
        if (head != null) {
            helper(head);
        }
        return head;
    }

    static Node helper(Node head) {
        Node curr = head;
        Node tail = null;

        while (curr != null) {
            Node child = curr.child;
            Node next = curr.next;

            if (child != null) {
                Node childTail = helper(child);

                curr.next = child;
                child.prev = curr;
                curr.child = null;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                curr = childTail;
            }

            if (curr.next == null) {
                tail = curr;
            }

            curr = curr.next;
        }

        return tail;
    }
}