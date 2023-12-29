package Trees;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = {0};
        helper(root, maxDiameter);
        return maxDiameter[0];
    }

    public int helper(TreeNode node, int[] maxDiameter) {
        if (node == null) {
            return 0;
        }

        int countLeft = helper(node.left, maxDiameter);
        int countRight = helper(node.right, maxDiameter);

        if (countLeft + countRight > maxDiameter[0]) {
            maxDiameter[0] = countLeft + countRight;
        }

        return Math.max(countLeft, countRight) + 1;
    }
}
