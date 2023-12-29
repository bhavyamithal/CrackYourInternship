package Trees;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }

    public TreeNode helper(TreeNode node) {
        if(node == null) {
            return null;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        helper(node.left);
        helper(node.right);

        return node;
    }
}
