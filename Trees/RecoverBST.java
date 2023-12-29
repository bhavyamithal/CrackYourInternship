package Trees;

// import java.util.ArrayList;
// import java.util.Collections;

public class RecoverBST {
    private TreeNode first;
    private TreeNode middle;
    private TreeNode prev;
    private TreeNode last;

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }

    // public void recoverTree(TreeNode root) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     inorder(root, list);
    //     Collections.sort(list);
    //     fixTree(root, list);
    // }

    // public void inorder(TreeNode node, ArrayList<Integer> list) {
    //     if (node == null) {
    //         return;
    //     }

    //     inorder(node.left, list);
    //     list.add(node.val);
    //     inorder(node.right, list);
    // }

    // int index = 0;
    // public void fixTree(TreeNode node, ArrayList<Integer> list) {
    //     if (node == null) {
    //         return;
    //     }

    //     fixTree(node.left, list);
    //     node.val = list.get(index);
    //     index++;
    //     fixTree(node.right, list);
    // }
}
