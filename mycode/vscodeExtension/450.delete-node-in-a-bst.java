/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key == root.val) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            TreeNode pre = null;
            TreeNode newRoot = root.left;
            while (newRoot.right != null) {
                pre = newRoot;
                newRoot = newRoot.right;
            }
            if (pre == null) {
                newRoot.right = root.right;
            } 
            else {
                pre.right = newRoot.left;
                newRoot.left = root.left;
                newRoot.right = root.right;
            }
            return newRoot;
        }
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    
// Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
// Once the node is found, have to handle the below 4 cases
// node doesn't have left or right - return null
// node only has left subtree- return the left subtree
// node only has right subtree- return the right subtree
// node has both left and right - find the minimum value in the right subtree, set that value to the currently found node, then recursively delete the minimum value in the right subtree
    
//     public TreeNode deleteNode(TreeNode root, int key) {
//         if (root == null) return null;
//         else if (root.val > key) root.left = deleteNode(root.left, key);
//         else if (root.val < key) root.right = deleteNode(root.right, key);
//         else {
//             if (root.left == null) return root.right;
//             else if (root.right == null) return root.left;
//             int min = findMin(root.right);
//             root.val = min;
//             root.right = deleteNode(root.right, min);
//         }
//         return root;
//     }
    
//     public int findMin(TreeNode root) {
//         if (root.left == null) return root.val;
//         return findMin(root.left);
        
//     }
}
// @lc code=end

