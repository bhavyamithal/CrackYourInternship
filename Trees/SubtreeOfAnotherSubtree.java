package Trees;

public class SubtreeOfAnotherSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean[] contains = { false };
        inorder(root, subRoot, contains);
        return contains[0];
    }

    public void inorder(TreeNode root, TreeNode subRoot, boolean[] contains) {
        if (root != null) {
            inorder(root.left, subRoot, contains);

            boolean x = match(root, subRoot);
            if (x) {
                contains[0] = true;
                return;
            }

            inorder(root.right, subRoot, contains);
        }
    }

    public boolean match(TreeNode root, TreeNode subRoot) {
        if (root != null && subRoot != null) {
            boolean left = match(root.left, subRoot.left);
            boolean right = match(root.right, subRoot.right);

            if ((root.val == subRoot.val) && left && right) {
                return true;
            } else {
                return false;
            }

        } else if (root == null && subRoot == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }
}