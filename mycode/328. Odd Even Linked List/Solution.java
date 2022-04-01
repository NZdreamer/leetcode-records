/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode oddDummy = new ListNode();
        oddDummy.next = head.next;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            pre = pre.next;
            cur.next = pre.next;
            cur = cur.next;
        }
        pre.next = oddDummy.next;
        return dummy.next;
    }
}