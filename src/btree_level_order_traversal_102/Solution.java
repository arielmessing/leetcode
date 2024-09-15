package btree_level_order_traversal_102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (! queue.isEmpty()) {
            var currentLevel = new ArrayList<Integer>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var current = queue.removeFirst();

                currentLevel.add(current.val);

                if (current.left != null) queue.addLast(current.left);
                if (current.right != null) queue.addLast(current.right);
            }
            
            result.add(currentLevel);
        }

        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}