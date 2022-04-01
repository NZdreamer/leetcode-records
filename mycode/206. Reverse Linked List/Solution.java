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
    public ListNode reverseList(ListNode head) {
        //迭代
        // if (head == null) return null;
        // Solution.ListNode cur = head;
        // Solution.ListNode pre = null;
        // Solution.ListNode next;
        // while (cur != null) {
        //     next = cur.next;
        //     cur.next = pre;
        //     pre = cur;
        //     cur = next;
        // }
        // return pre;

        //递归
        if (head == null) return null;
        return reverse(null, head);
    }
    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }
}