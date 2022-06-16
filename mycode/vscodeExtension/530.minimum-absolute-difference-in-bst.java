import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
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
    // int min = Integer.MAX_VALUE;
    // TreeNode pre = null;

    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        // getDifference(root);
        // return min;
        inOrder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) < min) {
                min = list.get(i + 1) - list.get(i);
            }
        }
        return min;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
        return;
    }

    // public void getDifference(TreeNode root) {
    //     if (root == null) return;
    //     getDifference(root.left);
    //     if (pre != null && root.val - pre.val < min) {
    //         min = root.val - pre.val;
    //     }
    //     pre = root;
    //     getDifference(root.right);
    //     return;
    // }
}
// @lc code=end

