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
    // public TreeNode sortedArrayToBST(int[] nums) {
    //     if (nums.length == 0) return null;
    //     if (nums.length == 1) {
    //         TreeNode root = new TreeNode(rootVal);
    //         return root;
    //     }
    //     int mid = nums.length / 2;
    //     int rootVal = nums[mid];
    //     TreeNode root = new TreeNode(rootVal);
    //     int[] left = Arrays.copyOfRange(nums, 0, mid);
    //     int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);
    //     root.left = sortedArrayToBST(left);
    //     root.right = sortedArrayToBST(right);
    //     return root;
    // }


    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}