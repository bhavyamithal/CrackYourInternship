package Trees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);

        return;
    }
}
