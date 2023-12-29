package Trees;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return convertBST(nums, 0, nums.length - 1);
    }

    public TreeNode convertBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = convertBST(nums, start, mid - 1);
        node.right = convertBST(nums, mid + 1, end);

        return node;
    }
}
