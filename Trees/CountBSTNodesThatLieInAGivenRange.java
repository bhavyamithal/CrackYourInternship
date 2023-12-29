package Trees;

public class CountBSTNodesThatLieInAGivenRange {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private int count = 0;

    public int getCount(Node root, int l, int h) {
        helper(root, l, h);
        return count;
    }

    public void helper(Node node, int low, int high) {
        if (node == null) {
            return;
        }

        if (node.data >= low && node.data <= high) {
            count++;
            helper(node.left, low, high);
            helper(node.right, low, high);
        } else if (node.data < low) {
            helper(node.right, low, high);
        } else if (node.data > high) {
            helper(node.left, low, high);
        }
    }
}
