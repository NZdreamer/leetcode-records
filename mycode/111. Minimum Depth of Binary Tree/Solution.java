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
    //DFS 前序遍历
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = 100000; //Integer.MAX_VALUE
        int rightDepth = 100000;
        if (root.left != null) leftDepth = 1 + minDepth(root.left);
        if (root.right != null) rightDepth = 1 + minDepth(root.right);
        return Math.min(leftDepth, rightDepth);
    }
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        if (root.left != null && root.right != null) {
//            return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
//        }
//        if (root.left != null) return 1 + minDepth(root.left);
//        if (root.right != null) return 1 + minDepth(root.right);
//        else return 1;
//    }

    //DFS 后序遍历
//    public int minDepth(TreeNode root) {
//        if(root == null) return 0;
//        int m1 = minDepth(root.left);
//        int m2 = minDepth(root.right);
//        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
//        //2.如果都不为空，返回较小深度+1
//        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;
//    }

//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        int leftDepth = minDepth(root.left);
//        int rightDepth = minDepth(root.right);
//        if (leftDepth == 0 || rightDepth == 0) return Math.max(leftDepth, rightDepth) + 1;
//        else return Math.min(leftDepth, rightDepth) + 1;
//    }

    //BFS
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Deque<TreeNode> deque = new LinkedList();   //deque的初始化
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode t = deque.poll();
                if (t.left == null && t.right == null) return depth;
                if (t.left != null) deque.offer(t.left);
                if (t.right != null) deque.offer(t.right);
            }
        }
        return depth;
    }

}