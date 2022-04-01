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
import java.util.*;
class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> hm = new HashMap();
        dfs(root, hm);
        Collection<Integer> values = hm.values();
        int max = Collections.max(values);
        List<Integer> res = new ArrayList();
        Set<Map.Entry<Integer,Integer>> entrySet = hm.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() == max) res.add(entry.getKey());
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    public void dfs(TreeNode root, HashMap<Integer, Integer> hm) {
        if (root == null) return;
        dfs(root.left, hm);
        if (hm.containsKey(root.val)) hm.put(root.val, hm.get(root.val) + 1);
        else hm.put(root.val, 1);
        dfs(root.right, hm);
    }
}