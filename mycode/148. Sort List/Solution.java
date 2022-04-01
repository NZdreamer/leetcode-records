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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    
    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (left != null && right != null) {
            if (left.val > right.val) {
                p.next = right;
                right = right.next;
            }
            else {
                p.next = left;
                left = left.next;
            }
            p = p.next;
        }
        if (left != null && right == null) {
            p.next = left;
        }
        if (left == null && right != null) {
            p.next = right;
        }
        return dummy.next;
        
        
        
        // ListNode newHead = new ListNode();
        // ListNode p = newHead;
        // if (left == null) return right;
        // if (right == null) return left;
        // while (left != null || right != null) {
        //     int l = left == null ? Integer.MIN_VALUE : left.val;
        //     int r = right == null ? Integer.MIN_VALUE : right.val;
        //     if (l < r) {
        //         p = left;
        //         left = left.next;
        //     }
        //     else {
        //         p = right;
        //         right = right.next;
        //     }
        //     p = p.next;
        // }
        // return newHead;
    }
}