class Solution {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MAX_VALUE);
    }

    public TreeNode bst(int[] nums, int bound) {
        if (i >= nums.length || nums[i] > bound) return null;
        TreeNode root = new TreeNode(nums[i]);
        i++;
        root.left = bst(nums, root.val);
        root.right = bst(nums, bound);
        return root;
    }
}