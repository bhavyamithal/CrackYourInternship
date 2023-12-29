package Trees;

import java.util.HashMap;

public class PathSumIII {
    int totalPaths = 0;
    
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        countPaths(root, targetSum, 0L, map);
        return totalPaths;
    }

    public void countPaths(TreeNode node, int target, long currSum, HashMap<Long, Integer> map) {
        if (node == null) {
            return;
        }

        currSum += node.val;
        long gain = currSum - target;
        if (map.containsKey(gain)) {
            totalPaths += map.get(gain);
        }

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        countPaths(node.left, target, currSum, map);
        countPaths(node.right, target, currSum, map);
        map.put(currSum, map.get(currSum) - 1);
    }

    // public int pathSum(TreeNode root, int targetSum) {
    // int[] numberOfPaths = { 0 };
    // dfs(root, targetSum, numberOfPaths);
    // return numberOfPaths[0];
    // }

    // public void dfs(TreeNode node, int target, int[] numberOfPaths) {
    // if (node == null) {
    // return;
    // }

    // countPath(node, target, 0, numberOfPaths);
    // dfs(node.left, target, numberOfPaths);
    // dfs(node.right, target, numberOfPaths);
    // }

    // public void countPath(TreeNode node, int target, long currSum, int[]
    // numberOfPaths) {
    // if (node == null) {
    // return;
    // }

    // currSum += (long) node.val;
    // if (currSum == target) {
    // numberOfPaths[0]++;
    // }

    // countPath(node.left, target, currSum, numberOfPaths);
    // countPath(node.right, target, currSum, numberOfPaths);
    // }
}
