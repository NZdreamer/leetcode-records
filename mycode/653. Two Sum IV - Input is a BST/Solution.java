import java.util.HashSet;

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
    HashSet<Integer> hs = new HashSet();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (hs.contains(root.val)) return true;
        hs.add(k - root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}

class Solution {
    HashSet<Integer> set = new HashSet();
    public Boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(root.val)) return true;
        set.add(k - root.val);
        if (findTarget(root.left, k)) return true;
        if (findTarget(root.right, k)) return true;
        return false;
    }
}

// class Solution {
//     HashSet<Integer> hs = new HashSet();
//     Boolean found = false;
//     public boolean findTarget(TreeNode root, int k) {
//         if (root == null) {
//             return false;
//         }
//         if (hs.contains(root.val)) {
//             found = true;
//             return found;
//         }
//         hs.add(k - root.val);
//         findTarget(root.left, k);
//         findTarget(root.right, k);
//         return found;
//     }
// }
