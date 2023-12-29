package Trees;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p, q);
    }

    public boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            return (node1.val == node2.val &&
                    helper(node1.left, node2.left) &&
                    helper(node1.right, node2.right));
        } else if (node1 == null && node2 == null) {
            return true;
        } else {
            return false;
        }
    }
}
