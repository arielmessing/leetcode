package kth_smallest_in_bst_230;

import java.util.Stack;

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

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || ! stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            k--;

            if (k == 0) return current.val;

            current = current.right;
        }

        return -1;
    }

    /*
    Recursive with hack
     */

    public int kthSmallest1(TreeNode root, int k) {
        int[] hack = new int[] { k , -1 };
        inorder(root, hack);

        return hack[1];
    }

    private void inorder(TreeNode root, int[] hack) {
        if (root == null) return;

        inorder(root.left, hack);

        hack[0]--;
        if (hack[0] == 0) {
            hack[1] = root.val;
            return;
        }

        inorder(root.right, hack);
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