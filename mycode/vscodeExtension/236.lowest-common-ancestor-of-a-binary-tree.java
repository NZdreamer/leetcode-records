/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p) return p;
        if (root == q) return q;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        if (root == p || root == q) return root;
        if (left == null) return right;
        if (right == null) return left;
        if (left != null & right != null) return root;
        return null;
    }

    // public boolean findNode(TreeNode root, TreeNode target) {
    //     if (root == null) return false;
    //     if (root == target) return true;
    //     return findNode(root.left, target) && findNode(root.right, target);
    // }
}
// @lc code=end

