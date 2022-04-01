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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        ListNode p = head;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        p = head;
        // if (k >= size) {
        //     for (int i = 0; i < k; i++) {
        //         if (p != null) {
        //             result[i] = new ListNode(p.val);
        //             p = p.next;
        //         }
        //         else {
        //             result[i] = null;
        //         }
        //     }
        // }
        // else {
        int subSize = size / k;
        int remainder = size % k;
        ListNode next = head;
        for (int i = 0; next != null && i < k; i++) {   //只需要在这里加上next != null 的条件，就不用写分情况讨论了，省去上面的一长串代码
            result[i] = next;
            if (i < remainder) {
                for (int j = 0; j < subSize; j++) {
                    p = p.next;
                }
            }
            else {
                for (int j = 0; j < subSize - 1; j++) {
                    p = p.next;
                }
            }
            next = p.next;
            p.next = null;
            p = next;
        }
        // }
        return result;
    }
}