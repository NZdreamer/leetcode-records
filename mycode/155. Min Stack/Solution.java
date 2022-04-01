class MinStack {
    private Node head;

    public void push(int x) {
        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

// class MinStack {

//     private Node head;

//     class Node {
//         int val;
//         int min;
//         Node next;

//         public Node(int val, int min) {
//             this.val = val;
//             this.min = min;
//         }
//     }

//     public MinStack() {
//     }

//     public void push(int val) {
//         if (head == null) {
//             head = new Node(val, val);
//         }
//         else {
//             int min = val < head.min ? val : head.min;
//             Node tmp = head;
//             head = new Node(val, min);
//             head.next = tmp;
//         }
//     }

//     public void pop() {
//         head = head.next;
//     }

//     public int top() {
//         return head.val;
//     }

//     public int getMin() {
//         return head.min;
//     }
// }

class MinStack {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MinStack() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void push(int val) {
        s1.push(val);
        if (s2.isEmpty()) s2.push(val);
        else {
            int min = Math.min(s2.peek(), val);
            s2.push(min);
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */