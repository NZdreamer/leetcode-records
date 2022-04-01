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
    public ListNode insertionSortList(ListNode head) {
//         if (head == null || head.next == null) return head;
//         ListNode dummy = new ListNode();
//         dummy.next = head;
//         ListNode pre = head;
//         ListNode cur = head.next;
//         head = dummy;
//         while (cur != null) {
//             ListNode next = cur.next;
//             while (head != cur && cur.val >= head.next.val) {
//                 head = head.next;
//             }
//             if (head == cur) {
//                 pre = pre.next;
//                 cur = cur.next;
//             }
//             else {
//                 cur.next = head.next;
//                 head.next = cur;
//                 pre.next = next;
//                 cur = next;
//             }
//             head = dummy;
//         }

//         return dummy.next;

        if (head == null || head.next == null) return head;
        ListNode helper = new ListNode();
        ListNode pre = helper;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            while (pre.next != null && pre.next.val < cur.val) {    //这条件？
                pre = pre.next;
            }
            next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }
        return helper.next;
    }
}