/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int ilo, int ihi, int plo, int phi) {
        if (ilo > ihi) return null;
        if (ilo == ihi) return new TreeNode(inorder[ilo]);
        TreeNode root = new TreeNode(postorder[phi]);
        int i = ilo;
        for (; i <= ihi; i++) {
            if (inorder[i] == postorder[phi]) break;
        }
        int leftlen = i - ilo;
        int rightlen = ihi - i;
        root.left = helper(inorder, postorder, ilo, i - 1, plo, plo + leftlen - 1);
        root.right = helper(inorder, postorder, i + 1, ihi, plo + leftlen, phi - 1);
        return root;
    }
}
// @lc code=end

