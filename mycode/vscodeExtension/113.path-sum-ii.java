import java.util.*;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        backtrace(root, res, new LinkedList<>(), targetSum, 0);
        return res;
        
    }

    public void backtrace(TreeNode root, List<List<Integer>> res, List<Integer> tmp, int targetSum, int sum) {
        if (root == null) return;
        
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) {
                res.add(new LinkedList<>(tmp));
            }
        }

        backtrace(root.left, res, tmp, targetSum, sum + root.val);
        backtrace(root.right, res, tmp, targetSum, sum + root.val);

        tmp.remove(tmp.size() - 1);
    }
}
// @lc code=end

