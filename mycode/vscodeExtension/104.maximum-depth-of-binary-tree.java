/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start
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

    // method 1: subproblem: can get the max depth of a tree by knowing the max depth of its children
    // public int maxDepth(TreeNode root) {
    //     if (root == null) return 0;
    //     return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    // }

    // method 2: traverse: keep a global depth
        int max = 0;
    public int maxDepth(TreeNode root) {
        traverse(root, 0);
        return max;
    }

    public void traverse(TreeNode root, int depth) {
        if (root == null) return;
        // pre
        depth++;
        max = Math.max(max, depth);
        traverse(root.left, depth);
        traverse(root.right, depth);
        // post
        depth--;
    }
}
// @lc code=end

