package Trees;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> currentLevel = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node == null) {
                result.add(new ArrayList<>(currentLevel));
                currentLevel.clear();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                currentLevel.add(node.val);
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
