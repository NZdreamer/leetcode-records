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
    // public boolean hasPathSum(TreeNode root, int targetSum) {
    //     return pathSum(root, 0, targetSum);
    // }
    // public boolean pathSum(TreeNode root, int sum, int targetSum) {
    //     if (root == null) return false;
    //     if (root.left == null && root.right == null && sum + root.val == targetSum) return true;
    //     if (root.left == null && root.right == null) return false;
    //     if (pathSum(root.left, sum + root.val, targetSum)) return true;
    //     if (pathSum(root.right, sum + root.val, targetSum)) return true;
    //     return false;
    // }

//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) return false;
//        if (root.left == null && root.right == null && targetSum - root.val == 0) return true;
//        if (root.left == null && root.right == null) return false;
//        if (hasPathSum(root.left, targetSum - root.val)) return true;
//        if (hasPathSum(root.right, targetSum - root.val)) return true;
//        return false;
//    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}