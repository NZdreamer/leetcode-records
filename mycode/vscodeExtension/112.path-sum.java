import java.nio.file.Paths;

/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    public boolean pathSum(TreeNode root, int targetSum, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) return true;
            else return false;
        }
        return pathSum(root.left, targetSum, sum + root.val) || pathSum(root.right, targetSum, sum + root.val);
    }
}
// @lc code=end

