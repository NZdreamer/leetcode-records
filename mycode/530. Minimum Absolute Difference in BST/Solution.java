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
    TreeNode pre = null;
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre != null && root.val - pre.val < minDiff) minDiff = root.val - pre.val;
        pre = root;
        inOrder(root.right);
    }

    // public int getValue(TreeNode root) {
    //     if (root.left == null && root.right == null) return root.val;
    //     if (root.left != null) {
    //         int left = getValue(root.left);
    //         if (root.val - left < minDiff) minDiff = root.val - left;
    //     }
    //     if (root.right != null) {
    //         int right = getValue(root.right);
    //         if (right - root.val < minDiff) minDiff = right - root.val;
    //     }
    //     return root.val;
    // }
}