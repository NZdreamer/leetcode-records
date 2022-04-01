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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail = reverse(null, slow.next);
        while(tail != null) {
            if (tail.val != head.val) return false;
            tail = tail.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }
}