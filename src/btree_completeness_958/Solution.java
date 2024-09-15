package btree_completeness_958;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode NULL = new TreeNode();
        boolean nullEncountered = false;

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();

            if (current == NULL) {
                nullEncountered = true;

            } else {
                if (nullEncountered) return false;

                if (current.left != null) queue.add(current.left);
                else queue.add(NULL);

                if (current.right != null) queue.add(current.right);
                else queue.add(NULL);
            }
        }

        return true;
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