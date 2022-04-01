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
    // 超时

    // public int rob(TreeNode root) {
    //     if (root == null) return 0;
    //     int val1 = root.val;
    //     if (root.left != null) {
    //         val1 += rob(root.left.left) + rob(root.left.right);
    //     }
    //     if (root.right != null) {
    //         val1 += rob(root.right.left) + rob(root.right.right);
    //     }
    //     int val2 = rob(root.left) + rob(root.right);
    //     return Math.max(val1, val2);
    // }


    // naive version of DP 用HashMap存已经计算过的节点

    // public int rob(TreeNode root) {
    //     HashMap<TreeNode, Integer> hm = new HashMap();
    //     return robHelper(root, hm);
    // }
    // public int robHelper(TreeNode root, HashMap<TreeNode, Integer> hm) {
    //     if (root == null) return 0;
    //     if (hm.containsKey(root)) return hm.get(root);
    //     else {
    //         int val1 = root.val;
    //         if (root.left != null) {
    //             val1 += robHelper(root.left.left, hm) + robHelper(root.left.right, hm);
    //         }
    //         if (root.right != null) {
    //             val1 += robHelper(root.right.left, hm) + robHelper(root.right.right, hm);
    //         }
    //         int val2 = robHelper(root.left, hm) + robHelper(root.right, hm);
    //         int res = Math.max(val1, val2);
    //         hm.put(root, res);
    //         return res;
    //     }
    // }


    // DP, 返回值是一个int[2]， 其中第一个元素表示不rob root节点的结果，第二个元素表示rob root节点的结果

    public int rob(TreeNode root) {
        return Math.max(robHelper(root)[0], robHelper(root)[1]);
    }
    public int[] robHelper(TreeNode root) {
        int[] res = new int[]{0, 0};
        if (root == null) return res;
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }


}