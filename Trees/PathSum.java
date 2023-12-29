package Trees;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }

    public boolean helper(TreeNode node, int targetSum, int currSum) {
        if (node == null) {
            return false;
        }

        currSum += node.val;
        if (node.left == null && node.right == null) {
            if (currSum == targetSum) {
                return true;
            }
        }

        return helper(node.left, targetSum, currSum) || helper(node.right, targetSum, currSum);
    }
}
