/**
 * Definition for singly-linked list.
 * public class Solution.ListNode {
 *     int val;
 *     Solution.ListNode next;
 *     Solution.ListNode() {}
 *     Solution.ListNode(int val) { this.val = val; }
 *     Solution.ListNode(int val, Solution.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        // Solution.ListNode cur = head;
        // Solution.ListNode pre = new Solution.ListNode(0, head);
        // while (cur != null) {
        //     if (cur.val == val) {
        //         pre.next = cur.next;
        //         cur = cur.next;
        //     }
        //     else {
        //         pre = pre.next;
        //         cur = cur.next;
        //     }
        // }

        //Solution.ListNode pre = new Solution.ListNode(0, head);
        //Solution.ListNode cur = pre;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        if (head.val == val ){
            head = head.next;
        }
        return head;
        //return pre.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(7);
        ListNode b = new ListNode(7, a);
        ListNode c = new ListNode(7, b);
        ListNode d = new ListNode(7, c);
        Solution s = new Solution();
        s.removeElements(d, 7);
    }
}