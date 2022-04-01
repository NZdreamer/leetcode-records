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

    //solution1: stack
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        int carry = 0;
        Stack<Integer> s3 = new Stack();
        while (!s1.empty() || !s2.empty()) {
            int n1 = s1.empty() ? 0 : s1.pop();
            int n2 = s2.empty() ? 0 : s2.pop();
            int sum = n1 + n2 + carry;
            s3.push(sum % 10);
            carry = sum / 10;
        }
        if (carry == 1) {
            s3.push(1);
        }
        while (!s3.empty()) {
            p.next = new ListNode(s3.pop());
            p = p.next;
        }
        return dummy.next;
    }

    //solution2: reverse
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode rev1 = reverse(l1);
//         ListNode rev2 = reverse(l2);
//         ListNode dummy = new ListNode();
//         ListNode p = dummy;
//         int carry = 0;
//         while (rev1 != null || rev2 != null) {
//             int n1 = rev1 == null ? 0 : rev1.val;
//             int n2 = rev2 == null ? 0 : rev2.val;
//             int sum = n1 + n2 + carry;
//             ListNode cur = new ListNode(sum % 10);
//             carry = sum / 10;
//             p.next = cur;
//             p = p.next;
//             if (rev1 != null) rev1 = rev1.next;
//             if (rev2 != null) rev2 = rev2.next;
//         }
//         if (carry == 1) {
//             ListNode cur = new ListNode(1);
//             p.next = cur;
//             p = p.next;
//         }
//         return reverse(dummy.next);
//      }

//     public ListNode reverse(ListNode head) {
//         if (head == null || head.next ==null) return head;
//         ListNode pre = null;
//         ListNode cur = head;
//         ListNode next = head;
//         while (cur != null) {
//             next = next.next;
//             cur.next = pre;
//             pre = cur;
//             cur = next;
//         }
//         return pre;
//     }
}