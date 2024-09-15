package btree_vertical_traversal_987;

import java.util.*;

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
    record NodeInPosition(TreeNode node, int row, int column) {}

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;

        Map<Integer, List<NodeInPosition>> nodesByColumn = new HashMap<>();
        Deque<NodeInPosition> queue = new ArrayDeque<>();
        queue.addLast(new NodeInPosition(root, 0, 0));

        int minColumn = 0, 
            maxColumn = 0;

        while (! queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                NodeInPosition top = queue.removeFirst();

                minColumn = Math.min(minColumn, top.column);
                maxColumn = Math.max(maxColumn, top.column);

                if (! nodesByColumn.containsKey(top.column))
                    nodesByColumn.put(top.column, new ArrayList<>());

                nodesByColumn.get(top.column).add(top);

                if (top.node.left != null) 
                    queue.addLast(new NodeInPosition(top.node.left, top.row + 1, top.column - 1));

                if (top.node.right != null) 
                    queue.addLast(new NodeInPosition(top.node.right, top.row + 1, top.column + 1));
            }
        }

        for (int i = minColumn; i <= maxColumn; i++) {
            List<NodeInPosition> nodes = nodesByColumn.get(i);

            results.add(
                nodes.stream()
                    .sorted((n1, n2) -> {
                            if (n1.row != n2.row) return n1.row - n2.row;
                            if (n1.column != n2.column) return n1.column - n2.column;
                            return n1.node.val - n2.node.val;
                           
                        })
                    .map(x -> x.node.val)
                    .toList()
            );
        }

        return results;
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