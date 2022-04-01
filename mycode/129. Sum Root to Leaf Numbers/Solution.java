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
//    int sum = 0;
//    public int sumNumbers(TreeNode root) {
//        sum(root, 0);
//        return sum;
//    }
//
//    public void sum(TreeNode root, int res) {
//        if (root == null) return;
//        res += root.val;
//        sum(root.left, res * 10);
//        sum(root.right, res * 10);
//        if (root.left == null && root.right == null) sum += res;
//    }

    public int sumNumbers(TreeNode root) {
        return sumNodes(root, 0);
    }

    private int sumNodes(TreeNode root, int currentSum) {
        if (root == null) return 0;
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) return currentSum;
        int leftSum = sumNodes(root.left, currentSum);
        int rightSum = sumNodes(root.right, currentSum);
        return leftSum + rightSum;
    }
}