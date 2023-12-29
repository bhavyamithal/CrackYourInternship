package Trees;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = { 0 };
        helper(root, false, sum);
        return sum[0];
    }

    public void helper(TreeNode node, boolean leftChild, int[] sum) {
        if (node == null) {
            return;
        }

        helper(node.left, true, sum);
        if (leftChild == true &&
                node.left == null &&
                node.right == null) {
            sum[0] += node.val;
        }
        helper(node.right, false, sum);

        return;
    }
}
