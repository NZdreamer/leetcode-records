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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        if (head == null || head.next == null) return head;
        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            if (pre.next == head) {
                pre = pre.next;
            }
            else {
                pre.next = head.next;
            }
            head = head.next;
        }

        // while (head.next != null) {
        //     if (head.val != head.next.val) {
        //         pre = pre.next;
        //         head = head.next;
        //     }
        //     else {
        //         if (head.next.next == null) {
        //             pre.next = null;
        //             head = head.next;
        //         }
        //         else if (head.next.val != head.next.next.val) {
        //             pre.next = head.next.next;
        //             head = pre.next;
        //         }
        //         else {
        //             head = head.next;
        //         }
        //     }
        // }


        return dummy.next;
    }
}