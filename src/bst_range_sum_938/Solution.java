package bst_range_sum_938;

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumBST_DFS(root, low, high);
    }

    private int rangeSumBST_DFS(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        
        if (root.val < low) {
            sum += rangeSumBST_DFS(root.right, low, high);
        
        } else if (root.val > high) {
            sum += rangeSumBST_DFS(root.left, low, high);
        
        } else {
            sum += rangeSumBST_DFS(root.left, low, high);
            sum += root.val;
            sum += rangeSumBST_DFS(root.right, low, high);
        }

        return sum;
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