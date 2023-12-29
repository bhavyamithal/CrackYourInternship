package Trees;

public class PredecessorAndSuccessor {
    static TreeNode pre = null;
    static TreeNode suc = null;

    public static void findPreSuc(TreeNode root, int key) {
        // code here.

        /*
         * There are two static nodes defined above pre(representing predecessor) and
         * suc(representing successor) as follows:
         * static Node pre=null,suc=null
         * You need to update these both.
         * And the val inside these classes will be printed automatically by the driver
         * code.
         */

        if (root == null) {
            return;
        }

        findPreSuc(root.left, key);

        if (root.val < key) {
            if (pre == null) {
                pre = root;
            } else {
                if (pre.val < root.val) {
                    pre = root;
                }
            }
        } else if (root.val > key) {
            if (suc == null) {
                suc = root;
            } else {
                if (suc.val > root.val) {
                    suc = root;
                }
            }
        }

        findPreSuc(root.right, key);

    }
}
