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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        backtrace(res, new LinkedList(), root);
        return res;
    }
    
    public void backtrace(List<String> res, List<Integer> tmp, TreeNode cur) {
        if (cur.left == null && cur.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i : tmp) {
                sb.append(i).append("->");
            }
            sb.append(cur.val);
            res.add(sb.toString());
            return;
        }
        tmp.add(cur.val);
        if (cur.left != null) backtrace(res, tmp, cur.left);
        if (cur.right != null) backtrace(res, tmp, cur.right);
        tmp.remove(tmp.size() - 1); 
    }
}