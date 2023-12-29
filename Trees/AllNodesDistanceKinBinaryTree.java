package Trees;

import java.util.*;

public class AllNodesDistanceKinBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans = new ArrayList<>();

        if (k == 0) {
            ans.add(target.val);
            return ans;
        }

        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        getParent(root, parentMap);

        bfs(target, k, parentMap, ans);

        return ans;
    }

    public void bfs(TreeNode target, int k, HashMap<TreeNode, TreeNode> parentMap, List<Integer> ans) {
        HashSet<TreeNode> visited = new HashSet<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        q.add(null);

        int distance = 0;

        while (!q.isEmpty()) {
            TreeNode node = q.remove();

            if (node == null) {
                if (distance == k - 1) {
                    while (!q.isEmpty()) {
                        ans.add(q.remove().val);
                    }
                } else {
                    if (!q.isEmpty()) {
                        distance++;
                        q.add(null);
                    }
                }
            } else {
                visited.add(node);

                if (node.left != null && !visited.contains(node.left)) {
                    q.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.add(node.right);
                }
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    q.add(parentMap.get(node));
                }

            }
        }
    }

    public void getParent(TreeNode root, HashMap<TreeNode, TreeNode> parentMap) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            parentMap.put(root.left, root);
        }
        getParent(root.left, parentMap);
        if (root.right != null) {
            parentMap.put(root.right, root);
        }
        getParent(root.right, parentMap);
    }
}
