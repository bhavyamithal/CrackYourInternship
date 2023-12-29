package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        ArrayList<Integer> temp = new ArrayList<>();
        boolean reverse = true;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                reverse = !reverse;
                if (reverse) {
                    Collections.reverse(temp);
                }
                result.add(new ArrayList<>(temp));
                temp.clear();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                temp.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return result;
    }
}
