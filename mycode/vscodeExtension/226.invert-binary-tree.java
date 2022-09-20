/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
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

   
    public TreeNode invertTree(TreeNode root) {
        // method 1: traverse
        // traverse(root);
        // return root;

        // method 2: subproblem
        // method definition: invert root tree and return the inverted tree
        
        if (root == null) return null;
        // invert left and right
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // swap left and right
        root.left = right;
        root.right = left;
        return root;
    }

    

    public void traverse(TreeNode root) {
        if (root == null) return;
        // swap
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        traverse(root.left);
        traverse(root.right);
    }
}
// @lc code=end

