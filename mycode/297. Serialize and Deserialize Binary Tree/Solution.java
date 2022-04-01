/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // preorder traverse
        if (root == null) return "null,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
//         StringBuilder sb = new StringBuilder();
//         Queue<TreeNode> q = new LinkedList();
//         q.add(root);
//         while (!q.isEmpty()) {
//             root = q.poll();
//             if (root == null) {
//                 sb.append("null").append(",");
//                 continue;
//             }
//             sb.append(root.val).append(",");

//             q.add(root.left);
//             q.add(root.right);
//         }
//         return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        Deque<String> nodes = new LinkedList(Arrays.asList(str));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String s = nodes.poll();
        if (s.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));