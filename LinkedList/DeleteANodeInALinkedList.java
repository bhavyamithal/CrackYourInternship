package LinkedList;

public class DeleteANodeInALinkedList {
    // delete a node, without head pointer and just the referance to that node
    // solution is simple
    // just copy the value of the next node to this node
    // and just change the node.next to node.next.next
    static void deleteNode(ListNode node) {
        if (node.next == null) {
            // if it is the last node, tail, which is to be deleted
            node = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
