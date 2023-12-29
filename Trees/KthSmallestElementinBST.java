package Trees;

public class KthSmallestElementinBST {
    private int k;
    private int ans;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return ans;
    }

    public void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        helper(node.left);
        k--;
        if (k == 0) {
            ans = node.val;
        }
        helper(node.right);
    }
}
