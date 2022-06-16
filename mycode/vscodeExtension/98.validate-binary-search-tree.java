/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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

 // 不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了。
 // 我们要比较的是 左子树所有节点小于中间节点，右子树所有节点大于中间节点。所以以上代码的判断逻辑是错误的。
class Solution {

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (pre >= root.val) return false;
        pre = root.val;
        boolean right = isValidBST(root.right);
        return left && right;
    }


    // public boolean isValidBST(TreeNode root) {
    //     return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    //     // if (root == null) return true;
    //     // boolean left = true;
    //     // boolean right = true;
    //     // if (root.left != null && root.val <= root.left.val) left = false;
    //     // if (root.right != null && root.val >= root.right.val) right = false;
    //     // return left && right;

    // }

    // public boolean dfs(TreeNode root, int lo, int hi) {
    //     if (root == null) return true;
    //     if (root.val > lo && root.val < hi) {
    //         return dfs(root.left, lo, root.val) && dfs(root.right, root.val, hi);
    //     }
    //     return false;
    //     // boolean left = false, right = false;
    //     // if (root.left == null) left = true;
    //     // else if (root.left.val > lo && root.left.val < hi) left = dfs(root.left, lo, root.val);
    //     // if (root.right == null) right = true;
    //     // else if (root.right.val > lo && root.right.val < hi) right = dfs(root.right, root.val, hi);
    //     // return left && right;
    // }
}
// @lc code=end

