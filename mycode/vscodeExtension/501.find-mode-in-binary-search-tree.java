import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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
    TreeNode pre = null;
    int count = 0;
    int maxCount = 0;
    List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] res = new int[modes.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = modes.get(i);
        }
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre != null && pre.val == root.val) {
            count++;
        }
        else count = 0;

        pre = root;

        if (count > maxCount) {
            maxCount = count;
            modes = new ArrayList<>();
            modes.add(root.val);
        }
        else if (count == maxCount) {
            modes.add(root.val);
        }
        inOrder(root.right);
    }
}
// @lc code=end

