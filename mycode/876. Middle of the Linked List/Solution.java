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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) { //error1: 缺少fat != null //error2: 两个条件顺序不能换
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}