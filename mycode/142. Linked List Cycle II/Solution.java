/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;


        // HashSet<ListNode> hs = new HashSet();
        // while (head.next != null) {
        //     if (hs.contains(head)) {
        //         return head;
        //     }
        //     else {
        //         hs.add(head);
        //     }
        //     head = head.next;
        // }
        // return null;
    }
}