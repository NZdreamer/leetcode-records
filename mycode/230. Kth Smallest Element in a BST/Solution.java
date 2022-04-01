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
//     public int kthSmallest(TreeNode root, int k) {
//         //List<Integer> list = new ArrayList();
//         //if (root == null) return 0;
//         Stack<TreeNode> stack = new Stack();
//         while (root != null || !stack.isEmpty()) {
//             if (root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
//             else {
//                 TreeNode node = stack.pop();
//                 //list.add(node.val);
//                 k--;
//                 if (k == 0) return node.val;
//                 root = node.right;
//             }

//         }
//         //return list.get(k - 1);
//         return 0;
//     }

    // public int kthSmallest(TreeNode root, int k) {
    //     if (root == null) return 0;
    //     kthSmallest(root.left, k);
    //     k--;
    //     if (k == 0) return root.val;
    //     kthSmallest(root.right, k);
    //     return 0;
    // }

    int res = 0;
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    public void inOrder(TreeNode root, int k) {
        if (root == null) return;
        inOrder(root.left, k);
        cnt++;
        if (k == cnt) {
            res = root.val;
            return;
        }
        inOrder(root.right, k);
    }

}