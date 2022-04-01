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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, inorder, preorder);
    }

    private TreeNode helper(int idx, int instart, int inend, int[] inorder, int[] preorder) {
        if (idx > preorder.length - 1) return null;
        if (inend < instart) return null;

        int mid = 0;
        for (int i = instart; i <= inend; i++) {
            if (preorder[idx] == inorder[i]) {
                mid = i;
            }
        }

        TreeNode root = new TreeNode(preorder[idx]);
        root.left = helper(idx + 1, instart, mid - 1, inorder, preorder);
        root.right = helper(idx + mid - instart + 1, mid + 1, inend, inorder, preorder);

        return root;
    }
}