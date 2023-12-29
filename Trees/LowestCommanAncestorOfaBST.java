package Trees;

public class LowestCommanAncestorOfaBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val == root.val || q.val == root.val) {
            return root;
        }

        TreeNode n = new TreeNode();
        if (p.val < root.val && q.val < root.val) {
            n = lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            n = lowestCommonAncestor(root.right, p, q);
        } else {
            n = root;
        }
        return n;
    }
}
