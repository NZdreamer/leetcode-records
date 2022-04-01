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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }
    public int goodNodes(TreeNode root, int max) {
        if (root == null) return 0;
        int res = 0;
        if (root.val >= max) {
            res += 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
        }
        else {
            res += goodNodes(root.left, max) + goodNodes(root.right, max);
        }
        return res;
    }
}