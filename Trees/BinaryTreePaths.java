package Trees;

import java.util.ArrayList;

public class BinaryTreePaths {
    public ArrayList<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> allPaths = new ArrayList<String>();
        if (root.left == null && root.right == null) {
            allPaths.add("" + root.val);
        }
        helper(root.left, allPaths, root.val + "");
        helper(root.right, allPaths, root.val + "");
        return allPaths;
    }

    public void helper(TreeNode node, ArrayList<String> allPaths, String currPath) {
        if (node == null) return;
        if (node != null && node.left == null && node.right == null) {
            allPaths.add(currPath + "->" + node.val);
            return;
        }

        helper(node.left, allPaths, currPath + "->" + node.val);
        helper(node.right, allPaths, currPath + "->" + node.val);

        return;
    }
}
