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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;

        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minheap.add(lists[i]);
            }
        }

        while (!minheap.isEmpty()) {
            ListNode min = minheap.poll();
            p.next = min;
            p = p.next;
            if (min.next != null) minheap.add(min.next);
        }

        return dummy.next;
    }
}