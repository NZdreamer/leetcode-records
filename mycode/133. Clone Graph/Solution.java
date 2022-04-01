/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> v = new HashMap();
        return helper(node, v);
    }

    private Node helper(Node node, HashMap<Integer, Node> visited) {
        if (node == null) return null;
        if (visited.containsKey(node.val)) return visited.get(node.val);
        Node root = new Node(node.val);
        visited.put(node.val, root);
        for (Node n : node.neighbors) {
            root.neighbors.add(helper(n, visited));
        }
        return root;
    }
}