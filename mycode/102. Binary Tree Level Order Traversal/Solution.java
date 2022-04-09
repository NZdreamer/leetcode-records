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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList();
        Queue<TreeNode> q = new LinkedList();
        if (root == null) return res; 
        q.add(root);
        while (!q.isEmpty()) {
            int lnum = q.size();
            List<Integer> levellist = new LinkedList();
            for (int i = 0; i < lnum; i++) {
                root = q.poll();
                levellist.add(root.val);
                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
            }
            res.add(levellist);
        }
        return res;
        
    }
}