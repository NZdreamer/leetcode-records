/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //solution1: three steps


        //solution2: hashmap
        if (head == null) return head;
        Node dummy = new Node(0, head, null);
        Node copied = new Node(0);
        Node dummy2 = new Node(0, copied, null);
        while (head.next != null) {
            copied.val = head.val;
            copied.next = new Node(0);
            head = head.next;
            copied = copied.next;
        }
        copied.val = head.val;
        copied.next = null;
        head = dummy.next;
        copied = dummy2.next;
        HashMap<Node, Node> hm = new HashMap();
        while (head != null) {
            hm.put(head, copied);
            head = head.next;
            copied = copied.next;
        }
        head = dummy.next;
        while (head != null) {
            hm.get(head).random = hm.get(head.random);
            head = head.next;
        }
        return dummy2.next;
    }
}