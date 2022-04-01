class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        return res;
    }

    public int top() {
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        int res = q1.peek();
        q2.offer(q1.poll());
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        return res;
    }

    public boolean empty() {
        if (q1.isEmpty()) return true;
        else return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */