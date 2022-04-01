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
    // public boolean isBalanced(TreeNode root) {
    //     if (root == null) return true;
    //     if (Math.abs(dfs(root.left) - dfs(root.right)) > 1) {
    //         return false;
    //     }
    //     if(isBalanced(root.right) == false) return false;
    //     if(isBalanced(root.left) == false) return false;
    //     return true;
    // }
    // public int dfs(TreeNode root) {
    //     if (root == null) return 0;
    //     int left = dfs(root.left);
    //     int right = dfs(root.right);
    //     return Math.max(right, left) + 1;
    // }
    public boolean isBalanced(TreeNode root) {
        if (dfs(root) == -1) return false;
        return true;
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        if (left == -1) return -1;
        int right = dfs(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        else return Math.max(left, right) + 1;
    }
}