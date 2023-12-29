package Trees;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, Long low, Long high) {
        if (node == null) {
            return true;
        }

        if (node.val <= low || node.val >= high) {
            return false;
        }

        return helper(node.left, low, (long) node.val) && helper(node.right, (long) node.val, high);
    }
}