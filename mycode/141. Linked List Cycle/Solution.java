/**
 * Definition for singly-linked list.
 * class Solution.ListNode {
 *     int val;
 *     Solution.ListNode next;
 *     Solution.ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodeSet = new HashSet();
        if (head == null) return false;
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return false;
    }

    //solution2：快慢指针
//    if (head == null) return false;
//    Solution.ListNode slow = head;
//    Solution.ListNode fast = head.next;
//        while (fast != null && fast.next != null) {
//        if (slow == fast) {
//            return true;
//        }
//        slow = slow.next;
//        fast = fast.next.next;
//    }
//        return false;
}