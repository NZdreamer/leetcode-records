/*
 * @lc app=leetcode id=707 lang=java
 *
 * [707] Design Linked List
 */

// @lc code=start
class LinkedNode {
    int val;
    LinkedNode next;
    LinkedNode pre;

    public LinkedNode() {}

    public LinkedNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    private LinkedNode dummy;
    private LinkedNode dummyTail;
    private int len;

    public MyLinkedList() {
        dummy = new LinkedNode();
        dummyTail = new LinkedNode();
        dummy.next = dummyTail;
        dummyTail.pre = dummy;
        len = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= len) return -1;
        LinkedNode p = dummy;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.val;
    }
    
    public void addAtHead(int val) {
        LinkedNode head = new LinkedNode(val);
        LinkedNode tmp = dummy.next;
        dummy.next = head;
        head.pre = dummy;
        head.next = tmp;
        tmp.pre = head;
        len++;
    }
    
    public void addAtTail(int val) {
        LinkedNode tail = new LinkedNode(val);
        LinkedNode tmp = dummyTail.pre;
        tmp.next = tail;
        tail.pre = tmp;
        tail.next =dummyTail;
        dummyTail.pre = tail;
        len++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > len) return;
        LinkedNode p = dummy;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        LinkedNode cur = new LinkedNode(val);
        LinkedNode next = p.next;
        p.next = cur;
        cur.pre = p;
        next.pre = cur;
        cur.next = next;
        len++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len) return;
        LinkedNode p = dummy;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        LinkedNode next = p.next.next;
        p.next = next;
        next.pre = p;
        len--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

