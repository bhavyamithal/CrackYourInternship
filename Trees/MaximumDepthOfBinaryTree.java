package Trees;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int[] maxDepth = {1};
        helper(root, maxDepth, 1);
        return maxDepth[0];
    }

    public void helper(TreeNode node, int[] maxDepth, int currDepth) {
        if (node == null) {
            return;
        }

        if (currDepth > maxDepth[0]) {
            maxDepth[0] = currDepth;
        }

        helper(node.left, maxDepth, currDepth + 1);
        helper(node.right, maxDepth, currDepth + 1);
        
        return;
    }
}
