package Trees;

public class MinDistanceBWTwoNodesOfBT {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public int findDist(Node root, int a, int b) {
        Node lca = lowestCommanAncestor(root, a, b);
        
        int distA = findDist(a, 0, lca);
        int distB = findDist(b, 0, lca);

        return distA + distB;
    }

    private int findDist(int a, int dist, Node node) {
        if (node == null) {
            return -1;
        }

        if (node.data == a) {
            return dist;
        }

        int left = findDist(a, dist + 1, node.left);
        int right = findDist(a, dist + 1, node.right);

        return (left != -1) ? left : right;
    }



    public Node lowestCommanAncestor(Node node, int a, int b) {
        if (node == null || node.data == a || node.data == b) {
            return node;
        }

        Node left = lowestCommanAncestor(node.left, a, b);
        Node right = lowestCommanAncestor(node.right, a, b);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return node;
    }
}
