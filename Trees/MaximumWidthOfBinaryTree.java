package Trees;

import java.util.HashMap;

public class MaximumWidthOfBinaryTree {
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxWidth = 0;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 0, 1);
        return maxWidth;
    }

    public void dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return;
        }

        dfs(node.left, depth + 1, (2 * index));
        map.putIfAbsent(depth, index);
        int levelWidth = index - map.get(depth) + 1;
        maxWidth = Math.max(maxWidth, levelWidth);
        dfs(node.right, depth + 1, (2 * index) + 1);
    }
}
