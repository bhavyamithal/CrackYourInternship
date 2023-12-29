package Trees;

public class MinimumAbsoluteDifferenceBST {

    public int getMinimumDifference(TreeNode root) {
        int[] ans = { Integer.MAX_VALUE };
        TreeNode[] prev = { null };
        dfs(root, prev, ans);
        return ans[0];
    }

    public void dfs(TreeNode node, TreeNode[] prev, int[] ans) {
        if (node == null) {
            return;
        }

        dfs(node.left, prev, ans);
        if (prev[0] != null) {
            ans[0] = Math.min(ans[0], Math.abs((prev[0].val - node.val)));
        }
        prev[0] = node;
        dfs(node.right, prev, ans);
        return;
    }
}
