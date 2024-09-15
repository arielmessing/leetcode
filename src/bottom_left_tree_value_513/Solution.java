package bottom_left_tree_value_513;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValueDFS(root);
    }

    private record Pair(int level, int val) {}

    private int findBottomLeftValueDFS(TreeNode root) {
        return findBottomLeftValueDFS(root, 0).val;
    }

    private Pair findBottomLeftValueDFS(TreeNode root, int level) {
        if (root == null) return null;

        if (root.left == null && root.right == null) return new Pair(level, root.val);

        Pair left = findBottomLeftValueDFS(root.left, level + 1);
        Pair right = findBottomLeftValueDFS(root.right, level + 1);

        if (left == null) return right;
        else if (right == null) return left;
        else if (left.level >= right.level) return left;
        else return right;
    }

    private int findBottomLeftValueBFS(TreeNode root) {
        int bottomLeft = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if (i == 0) bottomLeft = current.val;

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return bottomLeft;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}