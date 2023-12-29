package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideViewDFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 1, ans);
        return ans;
    }

    public void dfs(TreeNode node, int level, List<Integer> ans) {
        if (node == null) {
            return;
        }

        if (ans.size() < level) {
            ans.add(node.val);
        }
        dfs(node.right, level + 1, ans);
        dfs(node.left, level + 1, ans);
    }
}
