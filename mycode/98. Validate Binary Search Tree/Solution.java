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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        // TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode pre = null;
        while (!s.isEmpty() || root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            TreeNode cur = s.pop();
            if (pre != null && pre.val >= cur.val) return false;
            pre = cur;
            root = cur.right;
        }
        return true;
    }
}