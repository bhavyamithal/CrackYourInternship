package Trees;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeftChildren(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAllLeftChildren(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeftChildren(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
