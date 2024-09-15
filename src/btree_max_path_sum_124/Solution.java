package btree_max_path_sum_124;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumPostOrder(root);
        return max;
    }

    private int maxPathSumPostOrder(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(maxPathSumPostOrder(root.left), 0);
        int right = Math.max(maxPathSumPostOrder(root.right), 0);

        max = Math.max(max, left + right + root.val);

        return Math.max(left, right) + root.val;
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