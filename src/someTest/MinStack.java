package someTest;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        if (minStack.isEmpty() || number <= minStack.peek()){
            minStack.push(number);
        }
        stack.push(number);
    }

    public int pop() {
        // write your code here
        if (stack.isEmpty()){
            return Integer.MIN_VALUE;
        }
        int res = stack.pop();
        if (minStack.peek() == res) {
            minStack.pop();
        }
        return res;
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}

