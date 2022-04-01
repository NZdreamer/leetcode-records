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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = head;
        int size = 0;
        while(p.next != null) {
            p = p.next;
            size++;
        }
        size += 1;
        int n = k % size;
        // for (int i = 0; i < n; i++) {
        //     ListNode sec = new ListNode();
        //     ListNode tail;
        //     while (head.next != null) {
        //         sec = head;
        //         head = head.next;
        //     }
        //     tail = head;
        //     sec.next = null;
        //     tail.next = dummy.next;
        //     dummy.next = tail;
        //     head = tail;
        // }
        ListNode pre = dummy;
        ListNode cur = head;
        if (n == 0) return head;
        for (int i = 0; i < size - n; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        p.next = head;
        return cur;
    }
}