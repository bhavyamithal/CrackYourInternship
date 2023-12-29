package Trees;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {

            List<TreeNode> leftSubtrees = helper(start, i - 1);
            List<TreeNode> rightSubtrees = helper(i + 1, end);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right: rightSubtrees) {
                    TreeNode root = new TreeNode();
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }
}
