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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.next.val == pointer.val) {
                pointer.next = pointer.next.next;
            }
            else pointer = pointer.next;    //bug：这里没有加else

        }
        return head;
    }

    public static void main(String[] args) {

    }

}