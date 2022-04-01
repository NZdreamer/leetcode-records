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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prehead = dummy;
        ListNode cur = head.next;
        ListNode pre = head;
        while (prehead.next.val < x && cur != null) {
            prehead = prehead.next;
            pre = pre.next;
            cur = cur.next;
        }
        while (cur != null) {
            if (cur.val < x) {
                pre.next = pre.next.next;
                cur.next = prehead.next;
                prehead.next = cur;
                cur = pre.next;
                prehead = prehead.next;
            }
            else {
                cur = cur.next;
                pre = pre.next;
            }
        }        
        return dummy.next;
    }
//
//    public ListNode partition(ListNode head, int x) {
//        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
//        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
//        while (head!=null){
//            if (head.val<x) {
//                curr1.next = head;
//                curr1 = head;
//            }else {
//                curr2.next = head;
//                curr2 = head;
//            }
//            head = head.next;
//        }
//        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
//        curr1.next = dummy2.next;
//        return dummy1.next;
//    }
}