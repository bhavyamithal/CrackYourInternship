package Trees;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        boolean[] ans = { true };
        helper(root, 0, ans);
        return ans[0];
    }

    public int helper(TreeNode node, int height, boolean[] ans) {
        if (node == null) {
            return 0;
        }

        int leftHeight = helper(node.left, height, ans);
        int rightHeight = helper(node.right, height, ans);
        if (Math.abs(rightHeight - leftHeight) > 1) {
            ans[0] = false;
        }

        return Math.max(leftHeight + 1, rightHeight + 1);
    }
}
