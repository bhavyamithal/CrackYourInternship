package Trees;

public class SymmetricTrees {
    public boolean isSymmetric(TreeNode root) {
        return match(root.left, root.right);
    }

    public boolean match(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            if ((node1.val == node2.val) &&
                    match(node1.left, node2.right) &&
                    match(node1.right, node2.left)) {
                return true;
            } else
                return false;
        } else if (node1 == null && node2 == null) {
            return true;
        } else {
            return false;
        }
    }
}
