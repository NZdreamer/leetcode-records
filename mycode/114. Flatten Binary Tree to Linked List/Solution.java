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

    // private TreeNode prev = null;

    // public void flatten(TreeNode root) {
    //     if (root == null)
    //         return;
    //     flatten(root.right);
    //     flatten(root.left);
    //     root.right = prev;
    //     root.left = null;
    //     prev = root;
    // }


    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack();
        s.push(root);
        TreeNode p = new TreeNode();
        p.right = root;
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
                // p.right = node.left;
                // p.left = null;
                // p = p.right;
            }
            p.right = node;
            p.left = null;
            p = p.right;
        }
    }
}