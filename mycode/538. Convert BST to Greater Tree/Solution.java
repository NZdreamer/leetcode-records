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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        changeVal(root);
        return root;
    }
    // public int changeVal(TreeNode root) {
    //     if (root == null) return 0;
    //     int sum = changeVal(root.right) + root.val;
    //     root.val = sum;
    //     if (root.left != null) root.left.val += changeVal(root.left) + sum;
    //     return changeVal(root.left);
    // }

    public void changeVal(TreeNode root) {
        if (root == null) return;
        changeVal(root.right);
        sum += root.val;
        root.val = sum;
        changeVal(root.left);
    }
}

// 无全局变量（没看懂
//public class Solution {
//    public TreeNode convertBST(TreeNode root) {
//        if(root == null) return null;
//        DFS(root, 0);
//        return root;
//    }
//
//    public int DFS(TreeNode root, int preSum){
//        if(root.right != null) preSum = DFS(root.right, preSum);
//        root.val = root.val + preSum;
//        return (root.left != null) ? DFS(root.left, root.val) : root.val;
//    }
//}