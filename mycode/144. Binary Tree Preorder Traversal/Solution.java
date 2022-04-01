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
    // List<Integer> list = new ArrayList();
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     preorder(root);
    //     return list;
    // }
    // public void preorder(TreeNode root) {
    //     if (root == null) return;
    //     list.add(root.val);
    //     preorder(root.left);
    //     preorder(root.right);
    // }

    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList();
    //     preorder(root, list);
    //     return list;
    // }
    // public void preorder(TreeNode root, List<Integer> list) {
    //     if (root == null) return;
    //     list.add(root.val);
    //     preorder(root.left, list);
    //     preorder(root.right, list);
    // }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return list;
    }

    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList();
    //     if (root == null) return list;
    //     Stack<TreeNode> stack = new Stack();
    //     stack.push(root);
    //     while (!stack.isEmpty()) {
    //         if (root != null) {
    //             list.add(root.val);
    //             stack.push(root);
    //             root = root.left;
    //         }
    //         else {
    //             TreeNode node = stack.pop();
    //             root = node.right;
    //         }
    //     }
    //     return list;
    // }


}