/*
 * @lc app=leetcode id=701 lang=java
 *
 * [701] Insert into a Binary Search Tree
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
    // Method 3: 通过递归函数返回值完成新加入节点的父子关系赋值操作
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        if (root.val < val) root.right = insertIntoBST(root.right, val);
        return root;
    }
    

    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     // if (root == null) return new TreeNode(val);
    //     // helper(root, root, val);
    //     // return root;

    //     // Method 2: iteration
    //     if (root == null) return new TreeNode(val);
    //     TreeNode pre = root;
    //     TreeNode p = root;
    //     while (p != null) {
    //         pre = p;
    //         if (p.val > val) p = p.left;
    //         else if (p.val < val) p = p.right;
    //     }
    //     if (pre.val > val) pre.left = new TreeNode(val);
    //     else pre.right = new TreeNode(val);
    //     return root;
    // }

    // public void helper(TreeNode cur, TreeNode pre, int val) {
    //     if (cur == null) {
    //         TreeNode newNode = new TreeNode(val);
    //         if (pre.val > val) pre.left = newNode;
    //         else pre.right = newNode;
    //         return;
    //     }
    //     if (cur.val > val) {
    //         helper(cur.left, cur, val);
    //     }
    //     else if (cur.val < val) {
    //         helper(cur.right, cur, val);
    //     }
    // }
}
// @lc code=end

