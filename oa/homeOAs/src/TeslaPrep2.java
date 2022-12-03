import java.util.Stack;

// 包含min函数的栈
public class TeslaPrep2 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;


    public TeslaPrep2() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        if (val < minStack.peek()) {
            minStack.push(val);
        }
        else {
            minStack.push(minStack.peek());
        }
        stack.push(val);
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

class Main {
    public static void main(String[] args) {
        TeslaPrep2 minStack = new TeslaPrep2();
        minStack.push(3);
        minStack.push(2);
        minStack.push(5);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.push(1);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}
