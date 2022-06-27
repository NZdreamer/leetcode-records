import java.util.*;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        backtrace(root, res, new LinkedList<>());
        return res;
    }

    public void backtrace(TreeNode root, List<String> res, List<Integer> tmp) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.size(); i++) {
                sb.append(tmp.get(i)).append("->");
            }
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }

        tmp.add(root.val);
        backtrace(root.left, res, tmp);
        backtrace(root.right, res, tmp);
        tmp.remove(tmp.size() - 1);

    }
}
// @lc code=end

