package Trees;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(0, postorder.length - 1, preorder, postorder);
    }

    int preIndex = 0;

    public TreeNode helper(int postStart, int postEnd, int[] preorder, int[] postorder) {
        if (postStart > postEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIndex]);
        ++preIndex;
        if (postStart == postEnd) {
            return node;
        }
        int postIndex = find(preorder[preIndex], postorder);
        node.left = helper(postStart, postIndex, preorder, postorder);
        node.right = helper(postIndex + 1, postEnd - 1, preorder, postorder);
        return node;
    }

    public int find(int x, int[] postorder) {
        int index = 0;
        for (int i: postorder) {
            if (i == x) {
                return index;
            }
            index++;
        }
        return index;
    }
}
