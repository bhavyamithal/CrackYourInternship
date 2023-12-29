package Trees;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return helper(root1, root2);
    }

    public TreeNode helper(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            node1.val += node2.val;
            node1.left = helper(node1.left, node2.left);
            node1.right = helper(node1.right, node2.right);
        } else if (node1 == null && node2 != null) {
            node1 = new TreeNode(node2.val);
            node1.left = helper(node1.left, node2.left);
            node1.right = helper(node1.right, node2.right);
        } else if (node1 == null && node2 == null) {
            return null;
        }
        return node1;
    }
}
