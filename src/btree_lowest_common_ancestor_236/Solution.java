package btree_lowest_common_ancestor_236;

import java.util.BitSet;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    record TreeNode(int val, TreeNode left, TreeNode right) {
        TreeNode(int val) { this(val, null, null); }
    }

    private TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return lca;
    }

    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        BitSet bs = new BitSet(3);
        bs.set(0, findLCA(root.left, p, q));
        bs.set(1, findLCA(root.right, p, q));
        bs.set(2, root == p || root == q);

        if (bs.cardinality() >= 2) lca = root;

        return bs.cardinality() > 0;
    }

    public static void main(String[] args) {
        TreeNode p =
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4)));
        TreeNode q =
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8));

        TreeNode root = new TreeNode(3, p, q);

        System.out.println(new Solution().lowestCommonAncestor(root, p, q).val);
    }
}