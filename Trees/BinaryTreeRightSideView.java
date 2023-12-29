package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode prev = root;
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node == null) {
                ans.add(prev.val);
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            prev = node;
        }
        return ans;
    }
}
