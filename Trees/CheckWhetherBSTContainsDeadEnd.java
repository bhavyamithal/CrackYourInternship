package Trees;

public class CheckWhetherBSTContainsDeadEnd {
    public static boolean isDeadEnd(TreeNode root) {
        return preOrder(root, 1, Integer.MAX_VALUE);
    }

    public static boolean preOrder(TreeNode node, int low, int high) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null) {
            if (node.val == low && node.val == high) {
                return true;
            }
        }

        return preOrder(node.left, low, node.val - 1) || preOrder(node.right, node.val + 1, high);
    }
}
