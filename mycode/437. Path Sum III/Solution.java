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
//class Solution {
//     public int pathSum(TreeNode root, int targetSum) {
//         if (root == null) return 0;
//         return helper(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

//     }
//     public int helper(TreeNode root, int targetSum) {
//         if (root == null) return 0;
//         if (targetSum - root.val == 0) return 1 + helper(root.left, targetSum - root.val) + helper(root.right, targetSum - root.val);    //这里if的条件写targetSum == 0是错的
//         return helper(root.left, targetSum - root.val) + helper(root.right, targetSum - root.val);
//     }
//}

public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0, 1);
        return nodePathSum(root, targetSum, 0, hm);
    }

    public int nodePathSum(TreeNode root, int targetSum, int sum, HashMap<Integer, Integer> hm) {
        if (root == null) return 0;
        sum += root.val;
        int res = hm.getOrDefault(sum - targetSum, 0);
        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        res += nodePathSum(root.left, targetSum, sum, hm) + nodePathSum(root.right, targetSum, sum, hm);
        hm.put(sum, hm.get(sum) - 1);
        return res;
    }
}


// public class Solution {
//     public int pathSum(TreeNode root, int sum) {
//         if (root == null) {
//             return 0;
//         }
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, 1);
//         return findPathSum(root, 0, sum, map);
//     }
//     private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
//         if (curr == null) {
//             return 0;
//         }
//         // update the prefix sum by adding the current val
//         sum += curr.val;
//         // get the number of valid path, ended by the current node
//         int numPathToCurr = map.getOrDefault(sum-target, 0);
//         // update the map with the current sum, so the map is good to be passed to the next recursion
//         map.put(sum, map.getOrDefault(sum, 0) + 1);
//         // add the 3 parts discussed in 8. together
//         int res = numPathToCurr + findPathSum(curr.left, sum, target, map)
//                                                + findPathSum(curr.right, sum, target, map);
//        // restore the map, as the recursion goes from the bottom to the top
//         map.put(sum, map.get(sum) - 1);
//         return res;
//     }
// }


// public class Solution {
//     public int pathSum(TreeNode root, int sum) {
//         if (root == null) return 0;
//         return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//     }

//     private int pathSumFrom(TreeNode node, int sum) {
//         if (node == null) return 0;
//         return (node.val == sum ? 1 : 0)
//             + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
//     }
// }