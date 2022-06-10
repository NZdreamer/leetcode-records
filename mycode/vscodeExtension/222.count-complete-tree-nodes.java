/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        // int left = getLeft(root);
        // int right = getRight(root);
        int leftHeight = 0;
        int rightHeight = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (left != null) {
            left = left.left;
            leftHeight++;
        }
        while (right != null) {
            right = right.right;
            rightHeight++;
        }
        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        }
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    // public int getLeft(TreeNode root) {
    //     if (root == null) return 0;
    //     return getLeft(root.left) + 1;
    // }

    // public int getRight(TreeNode root) {
    //     if (root == null) return 0;
    //     return getRight(root.right) + 1;
    // }

}
// @lc code=end

