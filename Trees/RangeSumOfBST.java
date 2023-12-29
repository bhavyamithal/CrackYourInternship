package Trees;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] sum = {0};
        inorder(root, low, high, sum);
        return sum[0];
    }

    public void inorder(TreeNode root, int low, int high, int[] sum) {
        if (root == null) {
            return;
        }

        inorder(root.left, low, high, sum);

        if (root.val >= low && root.val <= high) {
            sum[0] += root.val;
        }

        inorder(root.right, low, high, sum);
    }
}
