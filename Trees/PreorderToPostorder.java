package Trees;

public class PreorderToPostorder {
    // GFG chutiya
    // problem is preorder to BST(construct)

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node post_order(int[] pre, int size) {
        Node root = createTree(pre, size, Integer.MAX_VALUE);
        return root;
    }

    static int i = 0;

    public static Node createTree(int[] preorder, int size, int max) {
        if (i == size || preorder[i] > max) {
            return null;
        }

        Node root = new Node(preorder[i]);
        i++;

        root.left = createTree(preorder, size, root.data);
        root.right = createTree(preorder, size, max);
        return root;
    }

    // public static Node post_order(int[] pre, int size) {
    // Node root = constructBST(pre, 0, size - 1);
    // return root;
    // }

    // static int index = 0;

    // public static Node constructBST(int[] preorder, int startIndex, int endIndex)
    // {
    // if (startIndex > endIndex) {
    // return null;
    // }

    // Node node = new Node(preorder[index]);
    // index++;
    // if (startIndex == endIndex) {
    // return node;
    // }

    // int middleIndex = findMiddle(preorder, index, endIndex, node.data);

    // node.left = constructBST(preorder, startIndex + 1, middleIndex - 1);
    // if (middleIndex != -1) {
    // node.right = constructBST(preorder, middleIndex, endIndex);
    // }
    // return node;
    // }

    // public static int findMiddle(int[] preorder, int s, int e, int val) {
    // for (int i = s; i <= e; i++) {
    // if (preorder[i] > val) {
    // return i;
    // }
    // }
    // return -1;
    // }
}
